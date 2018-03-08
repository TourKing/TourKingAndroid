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

    Phrase(String phrase, String translation) {
        this.phrase = phrase;
        this.translation = translation;
    }
    static String[] home = {"Hello", "Please", "Thank you", "I don't understand", "Do you speak English?", "Could you repeat that?"};
    static String[] transport = {"The train station", "I am lost", "I would like to go", "The airport", "A car", "One ticket please"};
    static String[] restaurant = {"I would like to order", "A table for two people", "Could I have the bill", "I am allergic to", "Water" };
    static String[] attractions = {"I'm looking for", "What time does it shut?", "Is this suitable for children?", "One ticket please", "Where are the toilets"};
    static String[] supermarket = {"How much is it?", "Do you take credit cards?", "I'm looking for"};

    public static ArrayList<String> translatedList = new ArrayList<>();

    public static ArrayList<Phrase> initialiseData(String category){
        ArrayList<Phrase> phrases = new ArrayList<>();
       // translatedList.clear();
        String[] eng;
        int i;
        switch(category){
            case "home":
                eng = home;
                break;
            case "transport":
                eng = transport;
                break;
            case "restaurant":
                eng = restaurant;
                break;
            case "attractions":
                eng = attractions;
                break;
            case "supermarket":
                eng = supermarket;
                break;
            default:
                eng = home;
                break;
        }
        for (i=0; i < eng.length; i++ ){
            try {
                System.out.println(eng[i]);
                textTranslate(eng[i], "en", "fr");
                System.out.println(translatedList.get(i));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error translating");
            }
        }
        for (i = 0; i < eng.length; i++) {
            String text = eng[i];
            String translation = translatedList.get(i);
            phrases.add(new Phrase(text, translation));
        }
        return phrases;


    }

    public static void textTranslate(final String input, String source, final String target) throws Exception {

        final String GOOGLE_API_KEY = "AIzaSyDfVhfHmQWt6avT4P2hRg0rulJ-tr1Dik4";

        final Handler textViewHandler = new Handler();
        String output = "";

        System.out.println(input);

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
                                    .replace("&#39;","\'")
                                    .replace("&quot;","\"");
                            System.out.println(translated);
                            setString(translated);

                    }
                });
                return null;
            }
        }.execute();

    }

    private static Void setString(String translated) {
        translatedList.add(translated);
        return null;
    }




}
