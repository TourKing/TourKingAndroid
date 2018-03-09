package com.holly.tourking;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.content.Intent;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements OnInitListener, NavigationView.OnNavigationItemSelectedListener {

    private TabHost mTabHost;

    private String section = "home";
    private int MY_DATA_CHECK_CODE = 0;
    private static TextToSpeech myTTS;

    private String translateLang = "French";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("TourKing");
        setSupportActionBar(toolbar);

        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

        final FloatingActionButton button = findViewById(R.id.translate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                startActivity(new Intent(MainActivity.this, popTranslate.class));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Set up TabHost
        TabHost mTabHost = findViewById(R.id.tabHost);
        this.mTabHost = mTabHost;
        mTabHost.setup();

        // Translating 'to' tab
        TabHost.TabSpec mSpec = mTabHost.newTabSpec("To");
        mSpec.setContent(R.id.to);
        mSpec.setIndicator("To " + translateLang);
        mTabHost.addTab(mSpec);

        // Translating 'from' tab
        mSpec = mTabHost.newTabSpec("From");
        mSpec.setContent(R.id.from);
        mSpec.setIndicator("From "+ translateLang);
        mTabHost.addTab(mSpec);

        // View on To tab on launch
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, ToPage.newInstance());
        transaction.commit();

        // Changing tabs
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("From")) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content, FromPage.newInstance());
                    transaction.commit();
                }
                if(tabId.equals("To")) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content, ToPage.newInstance());
                    transaction.commit();
                }
            }});

    }

    public static String getEmail(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getString("email", "");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Toolbar toolbar = findViewById(R.id.toolbar);

        switch (item.getItemId()){

            case R.id.nav_home:
                this.section = "home";
                toolbar.setTitle("TourKing");
                break;
            case R.id.nav_transport:
                this.section = "transport";
                toolbar.setTitle("Transport");
                break;
            case R.id.nav_restaurant:
                this.section = "restaurant";
                toolbar.setTitle("Restaurant");
                break;
            case R.id.nav_bar:
                this.section = "bar";
                toolbar.setTitle("Bar");
                break;
            case R.id.nav_attractions:
                this.section = "attractions";
                toolbar.setTitle("Attractions");
                break;
            case R.id.nav_supermarket:
                this.section = "supermarket";
                toolbar.setTitle("Supermarket");
                break;
            case R.id.nav_settings:
                this.section = "settings";
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
        }

        // hide drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        // move to To tab of selected section unless it's settings
        mTabHost.setCurrentTab(0);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, ToPage.newInstance());
        transaction.commit();

        return true;
    }

    public String getSection(){
        return this.section;
    }

    public static void beenWaiting(String talk, Integer lang){
        if (lang == 0){
            myTTS.setLanguage(Locale.UK);
        }else{
            myTTS.setLanguage(Locale.GERMAN);
        }
        myTTS.speak(talk, TextToSpeech.QUEUE_FLUSH, null);
    }


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
    }

    public void onInit(int initStatus) {
        if (initStatus == TextToSpeech.SUCCESS) {
            myTTS.setLanguage(Locale.GERMAN);
        }else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }

}
