package com.holly.tourking;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.speech.RecognizerIntent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.LanguageListOption;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.common.collect.ImmutableList;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.PrintStream;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.content.Intent;
import android.widget.Toast;

import java.util.Locale;

// Imports the Google Cloud client library
/**
 * Created by Connor on 05/03/2018.
 */

public class popTranslate extends Activity implements OnInitListener{

    EditText MyInputText;
    Button MyTranslateButton;
    ImageButton MySpeakButton;
    TextView MyOutputText;
    ImageButton MyListenButton;

    Translate translate;
    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech myTTS;


    private static final int REQ_CODE_SPEECH_INPUT = 100;
    Button myListenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_translate_window);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width *.8),(int)(height*.6));

        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

        MyInputText = findViewById(R.id.translate_input);
        MyTranslateButton = findViewById(R.id.translateButton);
        MySpeakButton = findViewById(R.id.SpeakButton);
        MyListenButton = findViewById(R.id.listenButton);
        MyOutputText = findViewById(R.id.translate_output);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        MyTranslateButton.setOnClickListener(MyTranslateButtonOnClickListener);
        MySpeakButton.setOnClickListener(MySpeakButtonOnClickListener);
        MyListenButton.setOnClickListener(MyListenButtonOnClickListener);


    }

    private Button.OnClickListener MyTranslateButtonOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            String InputString;
            String OutputString;
            InputString = MyInputText.getText().toString();

            try {
                OutputString = textTranslate(InputString, "en", "fr");
            } catch (Exception ex) {
                ex.printStackTrace();
                OutputString = "There was an error trying to translate your phrase. Please ensure you are connected to the internet.";
                MyOutputText.setText(OutputString);
            }

        }
    };

    private Button.OnClickListener MySpeakButtonOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            MyOutputText = findViewById(R.id.translate_output);
            if (MyOutputText != null){
                String output = MyOutputText.getText().toString();
                speakWords(output);
            }

        }
    };

    private Button.OnClickListener MyListenButtonOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Talk to Translate!");
            try {
                startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
            } catch (ActivityNotFoundException a) {

            }
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                myTTS = new TextToSpeech(this, this);
            }
            else {
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    MyInputText.setText(result.get(0));
                }
                break;
            }

        }
    }

    public void onInit(int initStatus) {
        if (initStatus == TextToSpeech.SUCCESS) {
            myTTS.setLanguage(Locale.FRANCE);
        }else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }

    private void speakWords(String speech) {
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    public Thread translateThread = new Thread(new Runnable () {
        @Override
        public void run() {
            try{
                translate = TranslateOptions.getDefaultInstance().getService();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });


    public String textTranslate(final String input, String source, final String target) throws Exception {

        final String GOOGLE_API_KEY = "AIzaSyDfVhfHmQWt6avT4P2hRg0rulJ-tr1Dik4";

            MyOutputText = findViewById(R.id.translate_output);
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
                            if (MyOutputText != null) {
                                MyOutputText.setText(translation.getTranslatedText().replace("&amp;","&")
                                        .replace("&lt;","<")
                                        .replace("&gt;",">")
                                        .replace("&quot;","\""));
                            }
                        }
                    });
                    return null;
                }
            }.execute();

            return output;
        }
}

