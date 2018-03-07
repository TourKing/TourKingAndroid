package com.holly.tourking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucy on 06/03/2018.
 */

public class Phrase {
    private String phrase;
    private String translation;
    private String phonetic;

    Phrase(String phrase, String translation, String phonetic) {
        this.phrase = phrase;
        this.translation = translation;
        this.phonetic = phonetic;
    }
    private List<Phrase> HomePhrases;
    private List<Phrase> Transport;
    private List<Phrase> Restaurant;
    private List<Phrase> Attractions;
    private List<Phrase> SuperMarket;

    private void initialiseData(){
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


}
