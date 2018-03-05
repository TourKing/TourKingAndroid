package com.holly.tourking;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ToPage extends Fragment {

    public ToPage() {
        // Required empty public constructor
    }

    public static ToPage newInstance() {
        ToPage fragment = new ToPage();
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
                tv1.setText("To Home 1");
                tv2.setText("To Home 2");
                break;
            case "transport":
                tv1.setText("To Transport 1");
                tv2.setText("To Transport 2");
                break;
            case "restaurant":
                tv1.setText("To Restaurant 1");
                tv2.setText("To Restaurant 2");
                break;
            case "attractions":
                tv1.setText("To Attractions 1");
                tv2.setText("To Attractions 2");
                break;
            case "supermarket":
                tv1.setText("To Supermarket 1");
                tv2.setText("To Supermarket 2");
                break;
        }

        return rootView;
    }
}