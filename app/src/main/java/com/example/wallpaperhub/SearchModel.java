package com.example.wallpaperhub;

import java.util.ArrayList;

public class SearchModel {
    private ArrayList<ImageModel> photos;

    public ArrayList<ImageModel> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<ImageModel> photos) {
        this.photos = photos;
    }

    public SearchModel(ArrayList<ImageModel> photos) {
        this.photos = photos;
    }
}
