package com.holly.tourking;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

public class FromPage extends Fragment {

    public FromPage() {
        // Required empty public constructor
    }

    public static FromPage newInstance() {
        FromPage fragment = new FromPage();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.phrases_page, container, false);


        TextView tv1 = rootView.findViewById(R.id.tv1);
        TextView tv2 = rootView.findViewById(R.id.tv2);

        switch (((MainActivity)getActivity()).getSection()){

            case "home":
                tv1.setText("From Home 1");
                tv2.setText("From Home 2");
                break;
            case "transport":
                tv1.setText("From Transport 1");
                tv2.setText("From Transport 2");
                break;
            case "restaurant":
                tv1.setText("From Restaurant 1");
                tv2.setText("From Restaurant 2");
                break;
            case "attractions":
                tv1.setText("From Attractions 1");
                tv2.setText("From Attractions 2");
                break;
            case "supermarket":
                tv1.setText("From Supermarket 1");
                tv2.setText("From Supermarket 2");
                break;
        }

        return rootView;
    }
}