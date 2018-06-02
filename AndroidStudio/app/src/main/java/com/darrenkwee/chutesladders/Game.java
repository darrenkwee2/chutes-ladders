package com.darrenkwee.chutesladders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Game extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final ImageButton dice = (ImageButton) findViewById(R.id.dice);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = new Dice().rollDice();
                if(i == 1) {
                    dice.setImageResource(R.drawable.dice1);
                } else if(i == 2) {
                    dice.setImageResource(R.drawable.dice2);
                } else if(i ==3) {
                    dice.setImageResource(R.drawable.dice3);
                }else if(i == 4) {
                    dice.setImageResource(R.drawable.dice4);
                }else if(i == 5) {
                    dice.setImageResource(R.drawable.dice5);
                }else if(i == 6) {
                    dice.setImageResource(R.drawable.dice6);
                }

                }

            });
        }

}



