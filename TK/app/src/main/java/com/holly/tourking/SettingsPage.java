package com.holly.tourking;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Lucy on 08/03/2018.
 */

public class SettingsPage extends Fragment {
    public SettingsPage() {
        // Required empty public constructor
    }

    public static SettingsPage newInstance() {
        SettingsPage fragment = new SettingsPage();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.settings_layout, container, false);
        Spinner from_selection = (Spinner) view.findViewById(R.id.from_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                    R.array.from_language_key, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_selection.setAdapter(adapter);

        return view;
    }
}
