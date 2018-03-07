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
                phrase1.setText("Hello");
                translation1.setText("Bonjour");

                phrase2.setText("I don't understand");
                translation2.setText("Je ne comprends pas");

                phrase3.setText("Could you repeat that please?");
                translation3.setText("Pouvez-vous répéter, s’il vous plaît.");

                break;
            case "transport":
                phrase1.setText("Hello");
                translation1.setText("Bonjour");

                phrase2.setText("I don't understand");
                translation2.setText("Je ne comprends pas");

                phrase3.setText("Could you repeat that please?");
                translation3.setText("Pouvez-vous répéter, s’il vous plaît.");

                break;
            case "restaurant":
                phrase1.setText("Hello");
                translation1.setText("Bonjour");

                phrase2.setText("I don't understand");
                translation2.setText("Je ne comprends pas");

                phrase3.setText("Could you repeat that please?");
                translation3.setText("Pouvez-vous répéter, s’il vous plaît.");
                break;
            case "attractions":
                phrase1.setText("Hello");
                translation1.setText("Bonjour");

                phrase2.setText("I don't understand");
                translation2.setText("Je ne comprends pas");

                phrase3.setText("Could you repeat that please?");
                translation3.setText("Pouvez-vous répéter, s’il vous plaît.");

                break;
            case "supermarket":
                phrase1.setText("Hello");
                translation1.setText("Bonjour");

                phrase2.setText("I don't understand");
                translation2.setText("Je ne comprends pas");

                phrase3.setText("Could you repeat that please?");
                translation3.setText("Pouvez-vous répéter, s’il vous plaît.");
                break;
        }

        return rootView;
    }
}