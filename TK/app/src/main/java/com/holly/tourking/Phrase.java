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


    //Constructor
    Phrase(String phrase, String translation) {
        this.phrase = phrase;
        this.translation = translation;
    }

    public static ArrayList<Phrase> phrases;

    public static ArrayList<Phrase> createPhraseList(String[] s1, String[] s2){
        phrases = new ArrayList<>();
        for(int i = 0; i < s1.length; i++){
            phrases.add(new Phrase(s1[i], s2[i]));
        }
        return phrases;
    }

    // Main method as called from To/From pages
    public static ArrayList<Phrase> initialiseData(int id, String category){

        switch(category) {
            case "home":
                if(id == 0){        // id is language (0 for french, 1 for german)
                    phrases = createPhraseList(engHome, frHome );
                } else {
                    phrases = createPhraseList(engHome, gerHome );
                }
                break;
            case "transport":
                if(id == 0){
                    phrases = createPhraseList(engTransport, frTransport );
                } else {
                    phrases = createPhraseList(engTransport, gerTransport );
                }

                break;
            case "bar":
                if(id == 0){
                    phrases = createPhraseList(engBar, frBar );
                } else {
                    phrases = createPhraseList(engBar, gerBar );
                }

                break;
            case "restaurant":
                if(id == 0){
                    phrases = createPhraseList(engRestaurant, frRestaurant );
                } else {
                    phrases = createPhraseList(engRestaurant, gerRestaurant );
                }

                break;
            case "attractions":
                if(id == 0){
                    phrases = createPhraseList(engAttractions, frAttractions );
                } else {
                    phrases = createPhraseList(engAttractions, gerAttractions );
                }
                break;
            case "supermarket":
                if(id == 0){
                    phrases = createPhraseList(engSupermarket, frSuperMarket );
                } else {
                    phrases = createPhraseList(engSupermarket, gerSuperMarket );
                }
                break;
        }

        return phrases;
    }


    // Here is all the data
    static String[] engHome = {"Hello", "Please", "Thank you", "Good-bye",
            "I would like...", "I don't understand", "Excuse me", "Where is the...?",
            "Could you repeat that please?", "Do you speak English?"};
    static String[] frHome = {"Bonjour", "S’il vous plaît", "Merci", "Au revoir",
            "Je voudrais...", "Je ne comprends pas", "Excusez-moi", "où est le/la...?",
            "Pouvez-vous répéter, s’il vous plaît.", "Parlez vous anglais?"
    };
    static String[] gerHome = {"Guten Tag", "Bitte", "Danke", "Auf Wiedersehen",
            "Ich möchte", "Ich verstehe nicht", "Entschuldigen Sie mich",
            "Wo ist der/die/das", "Könntest du das bitte wiederholen",
            "Sprichst du Englisch"};


    static  String[] engTransport = {"The train station", "I am lost", "I would like to go..",
            "The airport", "A car", "One ticket please"};
    static String[] frTransport = {"La gare", "Je suis perdu", "Je voudrais aller à... ",
            "L'aeroport", "Une voiture", "Un billet s'il vous plaît"};
    static String[] gerTransport = {"Der Bahnhof", "ich bin verloren", "ich würde gerne gehen",
            "Der Flughafen", "Einen Wagen", "Ein Ticket, bitte"};


    static String[] engRestaurant = {"I would like to order", "A table for two people",
            "Could I have the bill please?", "I am allergic to", "Water"};
    static String[] frRestaurant = {"je voudrais commander", "Une table pour deux personnes",
            "L’addition, s’il vous plaît", "Je suis allergique à", "L'eau"};
    static String[] gerRestaurant = {"Ich würde gerne bestellen", "Ein Tisch für zwei Personen",
            "Könnte ich bitte die Rechnung haben?", "ich bin allergisch gegen", "Wasser"};

    static String[] engBar = {"Hello", "Can I get you a drink", "I’m not a photographer, but I can picture me and you together.",
            "Are you religious? Because you’re the answer to all my prayers.", " I’m lost. Can you give me directions to your heart?",
            "Hi, how was heaven when you left it?", "Kiss me if I’m wrong, but dinosaurs still exist, right?"};
    static String[] frBar = {"Bonjour Mademoiselle", "Puis je vous proposer une boisson", "Je ne suis pas photographe, mais je peux vous imaginer et vous voir ensemble.",
            "Es-tu religieux? Parce que tu es la réponse à toutes mes prières.", "Je suis perdu. Pouvez-vous me donner des indications pour votre coeur?",
            "Salut, comment était le paradis quand tu l'as quitté?", "Embrasse-moi si je me trompe, mais les dinosaures existent toujours, non?"};
    static String[] gerBar = {"Hallo", "Kann ich dir ein Getränk holen", "Ich bin kein Fotograf, aber ich kann mich und dich zusammen vorstellen.",
            "Bist du religiös? Weil du die Antwort auf all meine Gebete bist.", "Ich bin verloren. Kannst du mir Anweisungen zu deinem Herzen geben?",
            "Hi, wie war der Himmel, als du es verlassen hast?", "Küss mich, wenn ich falsch liege, aber es gibt immer noch Dinosaurier, oder?"};

    static String[] engAttractions = {"I'm looking for", "What time does it shut?", "Is this suitable for children?",
            "One ticket please", "Where are the toilets"};
    static String[] frAttractions = {"Je cherche", "A quelle heure est-ce que cela ferme?", "Ceci convient aux enfants",
            "Un billet s'il vous plaît", "Où sont les toilettes"};
    static String[] gerAttractions = {"Ich suche", "Um welche Zeit schließt es", "Ist das für Kinder geeignet?",
            "Ein Ticket, bitte", "Wo sind die Toiletten"};

    static String[] engSupermarket = {"How much is it?", "Do you take credit cards?", "I'm looking for"};
    static String[] frSuperMarket = {"Combien ça coûte", "Prenez-vous les cartes de crédit", "Je cherche"};
    static String[] gerSuperMarket = {"Wie viel kostet das?", "Akzeptieren Sie Kreditkarten", "Ich suche" };






}
