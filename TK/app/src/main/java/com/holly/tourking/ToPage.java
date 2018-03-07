package com.holly.tourking;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        final Button button = rootView.findViewById(R.id.translate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Code here executes on main thread after user presses button
                startActivity(new Intent(getActivity(), popTranslate.class));
            }
        });

        int numOfCards = 3;

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
                phrase1.setText(phrases.get(0).phrase);
                translation1.setText(phrases.get(0).translation);

                phrase2.setText(phrases.get(1).phrase);
                translation2.setText(phrases.get(1).translation);

                phrase3.setText(phrases.get(2).phrase);
                translation3.setText(phrases.get(2).translation);

                break;
            case "transport":
                phrases = Phrase.Transport;
                phrase1.setText(phrases.get(0).phrase);
                translation1.setText(phrases.get(0).translation);

                phrase2.setText(phrases.get(1).phrase);
                translation2.setText(phrases.get(1).translation);

                phrase3.setText(phrases.get(2).phrase);
                translation3.setText(phrases.get(2).translation);
                break;
            case "restaurant":
                phrases = Phrase.Restaurant;
                phrase1.setText(phrases.get(0).phrase);
                translation1.setText(phrases.get(0).translation);

                phrase2.setText(phrases.get(1).phrase);
                translation2.setText(phrases.get(1).translation);

                phrase3.setText(phrases.get(2).phrase);
                translation3.setText(phrases.get(2).translation);
                break;
            case "attractions":
                phrases = Phrase.Attractions;
                phrase1.setText(phrases.get(0).phrase);
                translation1.setText(phrases.get(0).translation);

                phrase2.setText(phrases.get(1).phrase);
                translation2.setText(phrases.get(1).translation);

                phrase3.setText(phrases.get(2).phrase);
                translation3.setText(phrases.get(2).translation);
                break;
            case "supermarket":
                phrases = Phrase.SuperMarket;
                phrase1.setText(phrases.get(0).phrase);
                translation1.setText(phrases.get(0).translation);

                phrase2.setText(phrases.get(1).phrase);
                translation2.setText(phrases.get(1).translation);

                phrase3.setText(phrases.get(2).phrase);
                translation3.setText(phrases.get(2).translation);
                break;
        }

        return rootView;
    }
}