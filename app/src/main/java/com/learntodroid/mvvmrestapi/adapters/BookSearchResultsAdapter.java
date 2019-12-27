package com.learntodroid.mvvmrestapi.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learntodroid.mvvmrestapi.R;
import com.learntodroid.mvvmrestapi.models.Volume;
import com.learntodroid.mvvmrestapi.util.Util;

import java.util.ArrayList;
import java.util.List;

public class BookSearchResultsAdapter extends RecyclerView.Adapter<BookSearchResultsAdapter.BookSearchResultHolder> {
    private List<Volume> results = new ArrayList<>();

    @NonNull
    @Override
    public BookSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);

        return new BookSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSearchResultHolder holder, int position) {
        Volume volume = results.get(position);

        holder.titleTextView.setText(volume.getVolumeInfo().getTitle());
        holder.publishedDateTextView.setText(volume.getVolumeInfo().getPublishedDate());
        holder.smallThumbnailTextView.setText(volume.getVolumeInfo().getImageLinks().getSmallThumbnail());

        if (volume.getVolumeInfo().getAuthors() != null) {
            Util u = new Util();
            String authors = u.StringJoin(volume.getVolumeInfo().getAuthors(), ", ");
            holder.authorsTextView.setText(authors);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Volume> results) {
        this.results = results;
        notifyDataSetChanged(); // not ideal
    }

    class BookSearchResultHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView authorsTextView;
        private TextView publishedDateTextView;
        private TextView smallThumbnailTextView;

        public BookSearchResultHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.book_item_title);
            authorsTextView = itemView.findViewById(R.id.book_item_authors);
            publishedDateTextView = itemView.findViewById(R.id.book_item_publishedDate);
            smallThumbnailTextView = itemView.findViewById(R.id.book_item_smallThumbnail);
        }
    }
}
