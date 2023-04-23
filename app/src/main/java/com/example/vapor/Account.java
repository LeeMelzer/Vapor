package com.example.vapor;

public class Account {
    private int uid;
    private String username;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String address;
    private String card_number;
    private String card_code;
    private String expiration_month;
    private String expiration_year;

    public Account() {
        uid = -1;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFName() {
        return fName;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }
    public String getLName() {return lName;}
    public void setLName(String lName) {
        this.lName = lName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCardNumber() {
        return card_number;
    }
    public void setCardNumber(String card_number) {
        this.card_number = card_number;
    }
    public String getCardCode() {
        return card_code;
    }
    public void setCardCode(String card_code) {
        this.card_code = card_code;
    }
    public String getExpirationMonth() {
        return expiration_month;
    }
    public void setExpirationMonth(String expiration_month) {
        this.expiration_month = expiration_month;
    }
    public String getExpirationYear() {
        return expiration_year;
    }
    public void setExpirationYear(String expiration_year) {
        this.expiration_year = expiration_year;
    }
}
