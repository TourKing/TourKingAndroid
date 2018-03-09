package com.holly.tourking;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;

import java.util.List;

/**
 * Created by Lucy on 08/03/2018.
 */

public class ToPhraseAdapter extends RecyclerView.Adapter<ToPhraseAdapter.MyViewHolder> {
    private Context mContext;
    private List<Phrase> phrases;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView phrase, translation;
        public ImageButton speakButton;

        public MyViewHolder(View view) {
            super(view);
            phrase = (TextView) view.findViewById(R.id.phrase);
            translation = (TextView) view.findViewById(R.id.translation);
            speakButton = (ImageButton) itemView.findViewById(R.id.SpeakButton);
        }
    }


    public ToPhraseAdapter(Context mContext, List<Phrase> phrases){
        this.mContext = mContext;
        this.phrases = phrases;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phrases_page, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Phrase phrase = phrases.get(position);
        holder.phrase.setText(phrase.phrase);
        holder.translation.setText(phrase.translation);
        holder.speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                MainActivity.beenWaiting(phrase.translation, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return phrases.size();
    }

}
