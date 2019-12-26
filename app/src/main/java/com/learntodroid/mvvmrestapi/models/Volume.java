package com.learntodroid.mvvmrestapi.models;

public class Volume {
    String kind;

    String id;

    String etag;

    String selfLink;

    VolumeInfo volumeInfo;

    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
