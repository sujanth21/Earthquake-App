package com.example.android.quakereport;

/**
 * Created by Sujanth on 2/15/2017.
 */

public class Earthquake {

    private String mMagnitude;

    private String mLocation;

    private String mDate;

    public Earthquake(String mag, String place, String date) {
        mMagnitude = mag;
        mLocation = place;
        mDate = date;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }
}
