package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sujanth on 2/15/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {

        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);

        double magnitude = currentEarthquake.getmMagnitude();
        DecimalFormat decimalFormatter = new DecimalFormat("0.0");
        String displayMag = decimalFormatter.format(magnitude);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(displayMag);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String location = currentEarthquake.getmLocation();
        String primaryLocation = primaryLocation(location);
        String locationOffset = locationOffset(location);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        TextView locationView = (TextView) listItemView.findViewById(R.id.primary_location);
        locationView.setText(primaryLocation);

        Date date = new Date(currentEarthquake.getmDate());
        String formattedDate = formatDate(date);
        String formattedTime = formatTime(date);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(formattedTime);

        return listItemView;

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String primaryLocation (String location) {
        String locationString = location;

        if (location.contains("of")) {
            String[] parts = location.split("(?<=of)");
            String primaryLocation = parts[1];
            return primaryLocation;
        } else {
            return location;
        }
    }

    private String locationOffset (String location) {
        String locationString = location;

        if (location.contains("of")) {
            String[] parts = location.split("(?<=of)");
            String locationOffset = parts[0];
            return locationOffset;
        } else {
            return "Near the";
        }


    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceID;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceID = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceID = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceID = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceID = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceID = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceID = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceID = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceID = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceID = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceID = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceID);
    }
}
