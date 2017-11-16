package com.a12234.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by Meirina on 14/11/2017.
 */

public class tab_event extends Fragment {

    GridView gridview;

    String[] event = {
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd"
    };

    Integer[] image = {
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home,
            R.drawable.icon_home
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        LayoutEventAdapter adapter = new LayoutEventAdapter(getActivity(), event, image);
        gridview=(GridView) view.findViewById(R.id.grid);
        gridview.setAdapter(adapter);

        return view;
    }
}
