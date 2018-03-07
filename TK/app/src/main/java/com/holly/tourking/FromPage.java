package com.holly.tourking;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.List;

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

        CardView cv1 = rootView.findViewById(R.id.cv1);
        TextView phrase1 = rootView.findViewById(R.id.phrase1);
        TextView translation1 = rootView.findViewById(R.id.translation1);

        CardView cv2 = rootView.findViewById(R.id.cv2);
        TextView phrase2 = rootView.findViewById(R.id.phrase2);
        TextView translation2 = rootView.findViewById(R.id.translation2);

        CardView cv3 = rootView.findViewById(R.id.cv3);
        TextView phrase3 = rootView.findViewById(R.id.phrase3);
        TextView translation3 = rootView.findViewById(R.id.translation3);

        List<Phrase> phrases;
        Phrase.initialiseData();

        switch (((MainActivity)getActivity()).getSection()){

            case "home":
                phrases = Phrase.HomePhrases;
                phrase1.setText(phrases.get(0).translation);
                translation1.setText(phrases.get(0).phrase);

                phrase2.setText(phrases.get(1).translation);
                translation2.setText(phrases.get(1).phrase);

                phrase3.setText(phrases.get(2).translation);
                translation3.setText(phrases.get(2).phrase);

                break;
            case "transport":
                phrases = Phrase.Transport;
                phrase1.setText(phrases.get(0).translation);
                translation1.setText(phrases.get(0).phrase);

                phrase2.setText(phrases.get(1).translation);
                translation2.setText(phrases.get(1).phrase);

                phrase3.setText(phrases.get(2).translation);
                translation3.setText(phrases.get(2).phrase);
                break;
            case "restaurant":
                phrases = Phrase.Restaurant;
                phrase1.setText(phrases.get(0).translation);
                translation1.setText(phrases.get(0).phrase);

                phrase2.setText(phrases.get(1).translation);
                translation2.setText(phrases.get(1).phrase);

                phrase3.setText(phrases.get(2).translation);
                translation3.setText(phrases.get(2).phrase);
                break;
            case "attractions":
                phrases = Phrase.Attractions;
                phrase1.setText(phrases.get(0).translation);
                translation1.setText(phrases.get(0).phrase);

                phrase2.setText(phrases.get(1).translation);
                translation2.setText(phrases.get(1).phrase);

                phrase3.setText(phrases.get(2).translation);
                translation3.setText(phrases.get(2).phrase);
                break;
            case "supermarket":
                phrases = Phrase.SuperMarket;
                phrase1.setText(phrases.get(0).translation);
                translation1.setText(phrases.get(0).phrase);

                phrase2.setText(phrases.get(1).translation);
                translation2.setText(phrases.get(1).phrase);

                phrase3.setText(phrases.get(2).translation);
                translation3.setText(phrases.get(2).phrase);
                break;
        }

        return rootView;
    }
}