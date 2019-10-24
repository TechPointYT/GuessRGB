package com.example.guessrgb;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private int numBut = 6;
    private RGBR[] colors = new RGBR[6];
    private Switch diffi;
    private Button[] choices = new Button[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diffi = (Switch) findViewById(R.id.diff);
        setButtons();
        createColors();
        setColors();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        checkDifficulty();
    }

    public void checkDifficulty(){
        diffi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    easyMode();
                    numBut = 3;
                    createColors();
                }else{
                    hardMode();
                    numBut = 6;
                    createColors();
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

    public void createColors() {
        for (int col = 0; col < numBut; col++) {
            colors[col] = new RGBR();
        }
    }


    public void setColors(){
        int[] rgbCol;
        for(int but = 0; but < numBut; but++){
            rgbCol = colors[but].getRGB();
            choices[but].setBackgroundColor(Color.rgb(rgbCol[0], rgbCol[1], rgbCol[2]));
        }

    }





}
