package com.a12234.myapplication;

import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LayoutEventAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] event;
    private final Integer[] image;

    public LayoutEventAdapter(Activity context, String[] event, Integer[] image) {
        super(context, R.layout.activity_layout_event_adapter, event);

        this.context=context;
        this.event=event;
        this.image=image;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_layout_event_adapter, null,true);

        TextView txtTitle = (TextView)rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.image);

        txtTitle.setText(event[position]);
        imageView.setImageResource(image[position]);
        return rowView;

    };
}
