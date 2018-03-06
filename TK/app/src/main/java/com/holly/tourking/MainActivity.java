package com.holly.tourking;

import android.content.Intent;
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
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabHost mTabHost;

    private String section = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("TourKing");
        setSupportActionBar(toolbar);

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
        mSpec.setIndicator("To French");
        mTabHost.addTab(mSpec);

        // Tranlating 'from' tab
        mSpec = mTabHost.newTabSpec("From");
        mSpec.setContent(R.id.from);
        mSpec.setIndicator("From French");
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
        final Button button = findViewById(R.id.translate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                startActivity(new Intent(MainActivity.this, popTranslate.class));
            }
        });
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

        switch (item.getItemId()){

            case R.id.nav_home:
                this.section = "home";
                break;
            case R.id.nav_transport:
                this.section = "transport";
                break;
            case R.id.nav_restaurant:
                this.section = "restaurant";
                break;
            case R.id.nav_bar:
                this.section = "bar";
                break;
            case R.id.nav_attractions:
                this.section = "attractions";
                break;
            case R.id.nav_supermarket:
                this.section = "supermarket";
                break;
            case R.id.nav_settings:
                this.section = "settings";
                break;
        }

        // hide drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        // move to To tab of selected section
        mTabHost.setCurrentTab(0);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, ToPage.newInstance());
        transaction.commit();

        return true;
    }

    public String getSection(){
        return this.section;
    }
}
