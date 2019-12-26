package com.learntodroid.mvvmrestapi.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.learntodroid.mvvmrestapi.apis.VolumesResponse;
import com.learntodroid.mvvmrestapi.repositories.BookRepository;

public class BookSearchViewModel extends ViewModel {
    private static final String API_KEY = "AIzaSyDqiIHCwaW2xxhzHzfhQLkqcCRd_kdD8tQ";

    private BookRepository bookRepository;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public BookSearchViewModel() {

    }

    public void init() {
        Log.i(BookSearchViewModel.class.getSimpleName(), "init");
        bookRepository = new BookRepository();
        searchVolumes("", "", "");
    }

    public void searchVolumes(String keyword, String author, String apiKey) {
        Log.i(BookSearchViewModel.class.getSimpleName(), "searchVolumes");
        volumesResponseLiveData = bookRepository.searchVolumes("Stoic", "Seneca", API_KEY);
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
