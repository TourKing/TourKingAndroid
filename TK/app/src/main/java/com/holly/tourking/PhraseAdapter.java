package com.holly.tourking;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lucy on 09/03/2018.
 */

public class PhraseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<Phrase> phrases;
    private int toFrom, lang;
    public String section;

    public class PhraseViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView phrase, translation;
        public ImageButton speakButton;

        public ImageView flag;

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


    public PhraseAdapter(Context mContext, List<Phrase> phrases, String section, int toFrom, int lang){
        this.mContext = mContext;
        this.phrases = phrases;
        this.toFrom = toFrom;
        this.section = section;
        this.lang = lang;
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

    public int isToOrFrom(int toFrom) {
        /// 1 is TO, 0 is FROM
        if(toFrom == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType) == STATIC_CARD) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggested_card, parent, false);
            SuggestedViewHolder v = new SuggestedViewHolder(view);
            return v;
        } else {
            if (lang == 1) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phrases_page_ger, parent, false);
                return new PhraseViewHolder(itemView);
            } else {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phrases_page_fr, parent, false);
                return new PhraseViewHolder(itemView);
            }
        }
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final Phrase phrase = phrases.get(position);
        String toUse = "";

        if (getItemViewType(position) == DYNAMIC_CARD) {
            PhraseViewHolder mHolder = (PhraseViewHolder) holder;
            if(toFrom == 1) {
                mHolder.phrase.setText(phrase.phrase);
                mHolder.translation.setText(phrase.translation);
                toUse = phrase.translation;
            } else {
                mHolder.phrase.setText(phrase.translation);
                mHolder.translation.setText(phrase.phrase);
                toUse = phrase.phrase;
            }
            final String finalToUse = toUse;
            mHolder.speakButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.beenWaiting(finalToUse, toFrom);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return phrases.size();
    }

}
