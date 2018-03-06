package com.holly.tourking;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// Imports the Google Cloud client library
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

/**
 * Created by Connor on 05/03/2018.
 */

public class popTranslate extends Activity {

    EditText MyInputText;
    Button MyTranslateButton;
    TextView MyOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_translate_window);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width *.8),(int)(height*.6));

        MyInputText = findViewById(R.id.translate_input);
        MyTranslateButton = findViewById(R.id.TranslateButton);
        MyOutputText = findViewById(R.id.translate_output);

        MyTranslateButton.setOnClickListener(MyTranslateButtonOnClickListener);


    }

    private Button.OnClickListener MyTranslateButtonOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            String InputString;
            String OutputString;
            InputString = MyInputText.getText().toString();

            try {
                OutputString = textTranslate(InputString, "fr");
            } catch (Exception ex) {
                ex.printStackTrace();
                OutputString = "Error";
            }

            MyOutputText.setText(OutputString);

        }
    };

    public String textTranslate(String text, String target) throws Exception {
        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // The text to translate
        text = "Hello, world!";
        target = "ru";

        String output;

        // Translates some text into Russian
        Translation translation =
                translate.translate(
                        text,
                        TranslateOption.sourceLanguage("en"),
                        TranslateOption.targetLanguage(target));


        output = translation.getTranslatedText();

        System.out.printf("Text: %s%n", text);
        System.out.printf("Translation: %s%n", output);

        return output;
    }
}
