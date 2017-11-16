package com.a12234.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ListViewSettingAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] setting;
    private final Integer[] image;

    public ListViewSettingAdapter(Activity context, String[] setting, Integer[] image) {
        super(context, R.layout.activity_list_view_setting_handler, setting);

        this.context=context;
        this.setting=setting;
        this.image=image;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_list_view_setting_handler, null,true);

        TextView txtTitle = (TextView)rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.image);

        txtTitle.setText(setting[position]);
        imageView.setImageResource(image[position]);
        return rowView;

    };
}
