package com.holly.tourking;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucy on 06/03/2018.
 */

public class Phrase {
    public String phrase;
    public String translation;
    public String phonetic;

    Phrase(String phrase, String translation, String phonetic) {
        this.phrase = phrase;
        this.translation = translation;
        this.phonetic = phonetic;
    }
    public static List<Phrase> HomePhrases;
    public static List<Phrase> Transport;
    public static List<Phrase> Restaurant;
    public static List<Phrase> Attractions;
    public static List<Phrase> SuperMarket;

    ArrayList<String> translatedList = new ArrayList<>();

    public static void initialiseData(){
        HomePhrases = new ArrayList<>();
        HomePhrases.add(new Phrase("Hello", "Bonjour", "(phonetic)"));
        HomePhrases.add(new Phrase("I would like...", "Je voudrais...", "(phonetic)"));
        HomePhrases.add(new Phrase("I don't understand", "Je ne comprends pas", "(phonetic)"));
        HomePhrases.add(new Phrase("Could you repeat that please?", "Pouvez-vous répéter, s’il vous plaît.", "(phonetic)"));
        HomePhrases.add(new Phrase("Do you speak English?", "Parlez vous anglais?", "(phonetic)"));

        Transport = new ArrayList<>();
        Transport.add(new Phrase("A car", "Une voiture", "(phonetic)"));
        Transport.add(new Phrase("The train station", "La gare", "(phonetic)"));
        Transport.add(new Phrase("The airport", "L'aeroport", "(phonetic)"));
        Transport.add(new Phrase("We're lost", "Nous sommes perdus", "(phonetic)"));
        Transport.add(new Phrase("We would like to go...", "Nous voulons aller à...", "(phonetic)"));

        Restaurant = new ArrayList<>();
        Restaurant.add(new Phrase("I would like...", "Je voudrais...", "(phonetic)"));
        Restaurant.add(new Phrase("With cheese", "Au gratin", "(phonetic)"));
        Restaurant.add(new Phrase("Enjoy your food", "Bon apétit", "(phonetic)"));
        Restaurant.add(new Phrase("A table for two / four people", "Une table pour deux / quatre personnes. ", "(phonetic)"));
        Restaurant.add(new Phrase("Could I have the bill please?", "L’addition, s’il vous plaît", "(phonetic)"));

        Attractions = new ArrayList<>();
        Attractions.add(new Phrase("I’m looking for", "Je cherche", "(phonetic)"));
        Attractions.add(new Phrase("Where is...", "Ou est...", "(phonetic)"));
        Attractions.add(new Phrase("What time does it shut?", "A quelle heure est-ce que cela ferme?", "(phonetic)"));
        Attractions.add(new Phrase("What's the weather going to be like today?", "Quel temps va-t-il faire aujourd’hui? ", "(phonetic)"));
        Attractions.add(new Phrase("Do you speak English?", "Parlez vous anglais?", "(phonetic)"));

        SuperMarket = new ArrayList<>();
        SuperMarket.add(new Phrase("Price", "Prix", "(phonetic)"));
        SuperMarket.add(new Phrase("Credit card", "Carte de crédit", "(phonetic)"));
        SuperMarket.add(new Phrase("To buy", "Achete", "(phonetic)"));
        SuperMarket.add(new Phrase("How much is it?", "Combien ça coûte", "(phonetic)"));
        SuperMarket.add(new Phrase("Thank you", "Merci", "(phonetic)"));


    }

    public String textTranslate(final String input, String source, final String target) throws Exception {

        final String GOOGLE_API_KEY = "AIzaSyDfVhfHmQWt6avT4P2hRg0rulJ-tr1Dik4";

        final Handler textViewHandler = new Handler();
        String output = "";

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Translate translate = TranslateOptions.newBuilder().setApiKey(GOOGLE_API_KEY).build().getService();
                Log.i("Response:","works");
                final Translation translation =
                        translate.translate(input,
                                Translate.TranslateOption.targetLanguage(target));
                textViewHandler.post(new Runnable() {
                    @Override
                    public void run() {
                            String translated = translation.getTranslatedText().replace("&amp;","&")
                                    .replace("&lt;","<")
                                    .replace("&gt;",">")
                                    .replace("&quot;","\"");
                            setString(translated);

                    }
                });
                return null;
            }
        }.execute();

        return output;
    }

    private Void setString(String translated) {
        translatedList.add(translated);
        return null;
    }




}
