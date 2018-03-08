package com.holly.tourking;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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


       //View rootView = inflater.inflate(R.layout.phrases_page, container, false);

        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        /*CardView cv1 = rootView.findViewById(R.id.cv);
        TextView phrase1 = rootView.findViewById(R.id.phrase);
        TextView translation1 = rootView.findViewById(R.id.translation);*/

        List<Phrase> phrases;
        phrases = Phrase.initialiseData(((MainActivity)getActivity()).getSection());
        // phrases = Phrase.HomePhrases;

        rv.setAdapter(new ToPhraseAdapter(getContext(), phrases));

       /* switch (((MainActivity)getActivity()).getSection()){

            case "home":
                Phrase.initialiseData();
                phrases = Phrase.HomePhrases;
                rv.setAdapter(new FromPhraseAdapter(getContext(), phrases));
                break;
            case "transport":
                phrases = Phrase.Transport;
                rv.setAdapter(new FromPhraseAdapter(getContext(), phrases));
                break;
            case "restaurant":
                phrases = Phrase.Restaurant;
                rv.setAdapter(new FromPhraseAdapter(getContext(), phrases));
                break;
            case "attractions":
                phrases = Phrase.Attractions;
                rv.setAdapter(new FromPhraseAdapter(getContext(), phrases));
                break;
            case "supermarket":
                phrases = Phrase.SuperMarket;
                rv.setAdapter(new FromPhraseAdapter(getContext(), phrases));
                break;
        }*/

        return rv;
    }
}