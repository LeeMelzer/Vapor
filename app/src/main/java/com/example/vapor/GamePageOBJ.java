package com.example.vapor;

public class GamePageOBJ {

    /*
    gid INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ON DELETE CASCADE,
    video TEXT,
    img1 TEXT,
    img2 TEXT,
    img3 TEXT,
    title TEXT,
    description TEXT,
    long_desc TEXT,
    release_date TEXT,
    developer TEXT,
    publisher TEXT,
    total_review INTEGER,
    p_review INTEGER

    db.execSQL("INSERT INTO game VALUES (1, '','','','','Test Title','Test Desc', 'Test Long Desc', 'Test RDATE', 'Test Dev', 'Test Pub', 0, 0);");
     */

    private int gid;
    private String video;
    private String screenshot1;
    private String screenshot2;
    private String screenshot3;
    private String title;
    private String desc;
    private String about;
    private String date;
    private String developer;
    private String publisher;
    private int totalreview;
    private int preview;


    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getScreenshot1() {
        return screenshot1;
    }

    public void setScreenshot1(String screenshot1) {
        this.screenshot1 = screenshot1;
    }

    public String getScreenshot2() {
        return screenshot2;
    }

    public void setScreenshot2(String screenshot2) {
        this.screenshot2 = screenshot2;
    }

    public String getScreenshot3() {
        return screenshot3;
    }

    public void setScreenshot3(String screenshot3) {
        this.screenshot3 = screenshot3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getTotalreview() {
        return totalreview;
    }

    public void setTotalreview(int totalreview) {
        this.totalreview = totalreview;
    }

    public int getPreview() {
        return preview;
    }

    public void setPreview(int preview) {
        this.preview = preview;
    }
}
