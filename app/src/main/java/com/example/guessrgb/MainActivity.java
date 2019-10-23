package com.example.guessrgb;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private int numBut;
    private RGBR[] colors = new RGBR[6];
    private Switch diffi;
    private Button[] choices = new Button[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diffi = (Switch) findViewById(R.id.diff);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setButtons();
        checkDifficulty();
    }

    public void checkDifficulty(){
        diffi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    numBut = 6;
                    createColors(numBut);
                    hardMode();
                }else{
                    numBut = 3;
                    createColors(numBut);
                    easyMode();
                }
            }
        });
    }

    public void setButtons(){
        choices[0] = (Button) findViewById(R.id.color1);
        choices[1] = (Button) findViewById(R.id.color2);
        choices[2] = (Button) findViewById(R.id.color3);
        choices[3] = (Button) findViewById(R.id.color4);
        choices[4] = (Button) findViewById(R.id.color5);
        choices[5] = (Button) findViewById(R.id.color6);
    }

    public void  easyMode(){
        choices[3].setVisibility(View.GONE);
        choices[4].setVisibility(View.GONE);
        choices[5].setVisibility(View.GONE);
        
    }

    public void  hardMode(){
        choices[3].setVisibility(View.VISIBLE);
        choices[4].setVisibility(View.VISIBLE);
        choices[5].setVisibility(View.VISIBLE);
    }

    public void createColors(int numCol) {
        for (int col = 0; col < numCol; col++) {
            colors[col] = new RGBR();
        }

    }

}
