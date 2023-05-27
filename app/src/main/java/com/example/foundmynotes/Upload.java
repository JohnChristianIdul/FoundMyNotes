package com.example.foundmynotes;

public class Upload {
    private String mNumber;
    private String mImageurl;
    private String mDescription;

    public Upload(){}

    public Upload(String mImageurl,String mNumber, String mDescription){
        this.mImageurl = mImageurl;
        this.mNumber = mNumber;
        this.mDescription = mDescription;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmImageurl() {
        return mImageurl;
    }

    public void setmImageurl(String mImageurl) {
        this.mImageurl = mImageurl;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
