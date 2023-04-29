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
        return this.imageURL;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
