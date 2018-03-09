package com.holly.tourking;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
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

public class ToPhraseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Phrase> phrases;

    public class PhraseViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView phrase, translation;
        public ImageButton speakButton;

        public PhraseViewHolder(View view) {
            super(view);
            phrase = (TextView) view.findViewById(R.id.phrase);
            translation = (TextView) view.findViewById(R.id.translation);
            speakButton = (ImageButton) itemView.findViewById(R.id.SpeakButton);
        }


    }
    public class SuggestedViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView phrase, translation, quick;
        public ImageView image;

        public SuggestedViewHolder(View view) {
            super(view);
            phrase = (TextView) view.findViewById(R.id.phrase2);
            translation = (TextView) view.findViewById(R.id.translation2);
            quick = (TextView) view.findViewById(R.id.quick);
            image = (ImageView) view.findViewById(R.id.museum);
        }
    }


    public ToPhraseAdapter(Context mContext, List<Phrase> phrases){
        this.mContext = mContext;
        this.phrases = phrases;
    }

    private final int STATIC_CARD = 0;
    private final int DYNAMIC_CARD = 1;

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return STATIC_CARD;
        } else {
            return DYNAMIC_CARD;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(getItemViewType(viewType) == STATIC_CARD){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggested_card, parent, false);
            return new SuggestedViewHolder(view);
        } else{
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phrases_page, parent, false);
            return new PhraseViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final Phrase phrase = phrases.get(position);

        if (getItemViewType(position) == DYNAMIC_CARD) {
            PhraseViewHolder mHolder = (PhraseViewHolder) holder;

            mHolder.phrase.setText(phrase.phrase);
            mHolder.translation.setText(phrase.translation);
            mHolder.speakButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.beenWaiting(phrase.translation, 1);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return phrases.size();
    }

}
