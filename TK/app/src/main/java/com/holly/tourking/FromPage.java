package com.holly.tourking;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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


        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Phrase> phrases;
        phrases = Phrase.initialiseData(1, ((MainActivity)getActivity()).getSection());

        rv.setAdapter(new PhraseAdapter(getContext(), phrases, 0));
        return rv;
    }
}