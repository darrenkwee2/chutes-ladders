package com.example.darre.chutesandladders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView diceNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceNum = (TextView) findViewById(R.id.diceNum);//creates a reference
        Button diceButton = (Button) findViewById(R.id.dice);//casts to button
        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNum.setText(Integer.toString(new Dice().rollDice()));//add user input
            }
        });
    }
}
