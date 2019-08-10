package com.adityaprakash.ocr_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        {
private Button RecoText,LabelImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        myToolbar.setTitle("Home Page");
        myToolbar.setTitleTextColor(getResources().getColor(R.color.black));
        setSupportActionBar(myToolbar);

        RecoText = findViewById(R.id.textReco);
        LabelImage = findViewById(R.id.labelImage);

        RecoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent recoIntent = new Intent(MainActivity.this,TextRecognizer.class);
                startActivity(recoIntent);

            }
        });

        LabelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent labelIntent = new Intent(MainActivity.this,ImageLabeller.class);
                startActivity(labelIntent);

            }
        });



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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
