package com.hackindroid.kyoto.models;

/**
 * Created by Sushila on 12/15/2017.
 */

public class AdDetails {
    public String name;
    public String year;
    public String branch;
    public String phoneNo;
    public String bookTitle;
    public String bookDesc;
    public String price;

    public AdDetails(String name, String year, String branch, String phoneNo, String bookTitle, String bookDesc, String price) {
        this.name = name;
        this.year = year;
        this.branch = branch;
        this.phoneNo = phoneNo;
        this.bookTitle = bookTitle;
        this.bookDesc = bookDesc;
        this.price = price;
    }
    public AdDetails(){

    }
    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getBranch() {
        return branch;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public String getPrice() {
        return price;
    }


}
