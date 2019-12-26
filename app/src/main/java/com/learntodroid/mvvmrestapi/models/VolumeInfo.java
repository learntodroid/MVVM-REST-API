package com.learntodroid.mvvmrestapi.models;

import java.util.List;

public class VolumeInfo {
    String title;

    List<String> authors = null;

    String publisher;

    String publishedDate;

    String description;

    int pageCount;

    String printType;

    VolumeImageLinks imageLinks;

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public VolumeImageLinks getImageLinks() {
        return imageLinks;
    }
}
