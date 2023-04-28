package com.example.vapor;


//Class to store game info for library items
public class LibraryGame {

    private String imageURL;
    private String title;

    public LibraryGame(String imageURL, String title) {
        this.imageURL = imageURL;
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
