package com.holly.tourking;

/**
 * Created by Lucy on 09/03/2018.
 */

public class Language {
    public String languageName;
    public int languageID;

    Language(String name, int id) {
        this.languageName = name;
        this.languageID = id;
    }

    public String getLanguageName() {
        return this.languageName;
    }

    public int getLanguageID() {
        return this.languageID;
    }

    public void setLanguageName(String name) {
        this.languageName = name;
    }

    public void setLanguageID(int id) {
        this.languageID = id;
    }
}
