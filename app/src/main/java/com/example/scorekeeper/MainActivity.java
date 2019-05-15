package com.example.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mScore1;
    private int mScore2;
    private TextView ScoreTV1;
    private TextView ScoreTV2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScoreTV1 = findViewById(R.id.score_1);
        ScoreTV2 = findViewById(R.id.score_2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return true;
    }

    public void DecreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.decreaseTeam1:
            mScore1--;
            ScoreTV1.setText(String.valueOf(mScore1));
            break;

            case R.id.decreaseTeam2:
            mScore2--;
            ScoreTV2.setText(String.valueOf(mScore2));
            break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
            mScore1++;
            ScoreTV1.setText(String.valueOf(mScore1));
            break;
            case R.id.increaseTeam2:
            mScore2++;
            ScoreTV2.setText(String.valueOf(mScore2));
            break;
        }
    }
}
