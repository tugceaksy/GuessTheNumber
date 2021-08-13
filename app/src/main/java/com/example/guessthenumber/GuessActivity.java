package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {
    private EditText numberinEdittext;
    private Button guessbutton;
    private TextView lastChancetextView,increasetextView;
    private int randomNumber;
    private int lastChance=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        numberinEdittext=findViewById(R.id.numberinEdittext);
        guessbutton=findViewById(R.id.guessbutton);
        increasetextView=findViewById(R.id.increasetextView);
        lastChancetextView=findViewById(R.id.lastChancetextView);
        Random r =new Random();
        randomNumber = r.nextInt(101);



        guessbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               lastChance=lastChance-1;
               int guess=Integer.parseInt(numberinEdittext.getText().toString());
               if(guess==randomNumber){
                   Intent i =new Intent(GuessActivity.this,ResultActivity.class);
                   i.putExtra("result",true);
                   startActivity(i);
                   finish();
                   return;

               }
                if(guess>randomNumber){
                increasetextView.setText("AZALT");
                    lastChancetextView.setText("KALAN HAK:"+lastChance);

                }
                if(guess<randomNumber){
                    increasetextView.setText("AZALT");
                    lastChancetextView.setText("KALAN HAK:"+lastChance);
                }
                if(lastChance==0){
                    Intent i =new Intent(GuessActivity.this,ResultActivity.class);
                    i.putExtra("result",false);
                    startActivity(i);
                    finish();

                }
                numberinEdittext.setText("");


               // startActivity(new Intent(GuessActivity.this, ResultActivity.class));
               // finish();
            }
        });
    }
}