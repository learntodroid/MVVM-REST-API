package com.learntodroid.mvvmrestapi.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learntodroid.mvvmrestapi.apis.VolumesResponse;
import com.learntodroid.mvvmrestapi.repositories.BookRepository;

import io.github.cdimascio.dotenv.Dotenv;

public class BookSearchViewModel extends ViewModel {
    private BookRepository bookRepository;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public void init() {
        Log.i(BookSearchViewModel.class.getSimpleName(), "init");
        bookRepository = new BookRepository();
        searchVolumes("", "", "");
    }

    public void searchVolumes(String keyword, String author, String apiKey) {
        Log.i(BookSearchViewModel.class.getSimpleName(), "searchVolumes");
        Dotenv dotenv = Dotenv.configure().directory("/assets").filename("env").load();
        volumesResponseLiveData = bookRepository.searchVolumes("Stoic", "Seneca", dotenv.get("GOOGLE_API_KEY"));
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
