package com.learntodroid.mvvmrestapi.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }

    public void searchVolumes(String keyword, String author) {
        Log.i(BookSearchViewModel.class.getSimpleName(), "searchVolumes");
        Dotenv dotenv = Dotenv.configure().directory("/assets").filename("env").load();
        bookRepository.searchVolumes(keyword, author, dotenv.get("GOOGLE_API_KEY"));
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
