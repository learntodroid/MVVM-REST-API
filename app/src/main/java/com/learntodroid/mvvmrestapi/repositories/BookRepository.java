package com.learntodroid.mvvmrestapi.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learntodroid.mvvmrestapi.apis.BookSearchService;
import com.learntodroid.mvvmrestapi.apis.VolumesResponse;
import com.learntodroid.mvvmrestapi.models.Volume;
import com.learntodroid.mvvmrestapi.viewmodels.BookSearchViewModel;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookRepository {
    private BookSearchService bookSearchService;
    private static final String BOOK_SEARCH_SERVICE_BASE_URL = "https://www.googleapis.com/";

    public BookRepository() {
        Log.i(BookRepository.class.getSimpleName(), "constructor");

        // add a http logging interceptor to help debugging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        bookSearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(BOOK_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookSearchService.class);
    }

    public LiveData<VolumesResponse> searchVolumes(String keyword, String author, String apiKey) {
        final MutableLiveData<VolumesResponse> data = new MutableLiveData<>();
        Log.i(BookRepository.class.getSimpleName(), "searchVolumes");
        bookSearchService.searchVolumes(keyword, author, apiKey)
                .enqueue(new Callback<VolumesResponse>() {
                    @Override
                    public void onResponse(Call<VolumesResponse> call, Response<VolumesResponse> response) {
                        Log.i(BookRepository.class.getSimpleName(), response.message());
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<VolumesResponse> call, Throwable t) {
                        Log.i(BookRepository.class.getSimpleName(), t.getMessage());
                        data.setValue(null);
                    }
                });
        return data;
    }
}
