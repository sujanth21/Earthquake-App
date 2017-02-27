package com.example.android.quakereport;

/**
 * Created by Sujanth on 2/15/2017.
 */

public class Earthquake {

    private double mMagnitude;

    private String mLocation;

    private long mDate;

    public Earthquake(double mag, String place, long date) {
        mMagnitude = mag;
        mLocation = place;
        mDate = date;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmDate() {
        return mDate;
    }
}
