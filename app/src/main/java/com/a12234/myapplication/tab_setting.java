package com.a12234.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Meirina on 14/11/2017.
 */

public class tab_setting extends Fragment {
    ListView listview;

    String[] setting = {
            "Notification",
            "Change Password",
            "F.A.Q",
            "Rate this app",
            "About",
            "Logout"
    };

    Integer[] image = {
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
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        ListViewSettingAdapter adapter = new ListViewSettingAdapter(getActivity(), setting, image);
        listview=(ListView)view.findViewById(R.id.list);
        listview.setAdapter(adapter);

//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });

        return view;
    }
}
