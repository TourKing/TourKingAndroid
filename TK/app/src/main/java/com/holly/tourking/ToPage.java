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


        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Phrase> phrases;
        phrases = Phrase.initialiseData(1, ((MainActivity)getActivity()).getSection());

        rv.setAdapter(new ToPhraseAdapter(getContext(), phrases));

        return rv;
    }
}