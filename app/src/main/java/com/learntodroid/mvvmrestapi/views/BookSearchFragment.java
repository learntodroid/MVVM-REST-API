package com.learntodroid.mvvmrestapi.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learntodroid.mvvmrestapi.R;
import com.learntodroid.mvvmrestapi.adapters.BookSearchResultsAdapter;
import com.learntodroid.mvvmrestapi.apis.VolumesResponse;
import com.learntodroid.mvvmrestapi.viewmodels.BookSearchViewModel;

public class BookSearchFragment extends Fragment {
    private BookSearchViewModel viewModel;
    private BookSearchResultsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new BookSearchResultsAdapter();

        viewModel = ViewModelProviders.of(this).get(BookSearchViewModel.class);
        viewModel.init();
        viewModel.getVolumesResponseLiveData().observe(this, new Observer<VolumesResponse>() {
            @Override
            public void onChanged(VolumesResponse volumesResponse) {
                adapter.setResults(volumesResponse.getItems());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booksearch, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
