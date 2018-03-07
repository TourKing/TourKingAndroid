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

        switch (((MainActivity)getActivity()).getSection()){

            case "home":
                phrase1.setText("Bonjour");
                translation1.setText("Hello");

                phrase2.setText("Je ne comprends pas");
                translation2.setText("I don't understand");

                phrase3.setText("Pouvez-vous répéter, s’il vous plaît.");
                translation3.setText("Could you repeat that please?");

                break;
            case "transport":
                phrase1.setText("Bonjour");
                translation1.setText("Hello");

                phrase2.setText("Je ne comprends pas");
                translation2.setText("I don't understand");

                phrase3.setText("Pouvez-vous répéter, s’il vous plaît.");
                translation3.setText("Could you repeat that please?");
                break;
            case "restaurant":
                phrase1.setText("Bonjour");
                translation1.setText("Hello");

                phrase2.setText("Je ne comprends pas");
                translation2.setText("I don't understand");

                phrase3.setText("Pouvez-vous répéter, s’il vous plaît.");
                translation3.setText("Could you repeat that please?");
                break;
            case "attractions":
                phrase1.setText("Bonjour");
                translation1.setText("Hello");

                phrase2.setText("Je ne comprends pas");
                translation2.setText("I don't understand");

                phrase3.setText("Pouvez-vous répéter, s’il vous plaît.");
                translation3.setText("Could you repeat that please?");

            break;
            case "supermarket":
                phrase1.setText("Bonjour");
                translation1.setText("Hello");

                phrase2.setText("Je ne comprends pas");
                translation2.setText("I don't understand");

                phrase3.setText("Pouvez-vous répéter, s’il vous plaît.");
                translation3.setText("Could you repeat that please?");
                break;
        }

        return rootView;
    }
}