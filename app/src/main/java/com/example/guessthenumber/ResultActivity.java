package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private Button trybutton;
    private TextView resulttextview;
    private ImageView resultimageview;
    private Boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        trybutton=findViewById(R.id.trybutton);
        resultimageview=findViewById(R.id.resultimageView);
        resulttextview=findViewById(R.id.resulttextView);
        result=getIntent().getBooleanExtra("result",false);
        if(result){
    resulttextview.setText("YOU ARE THE WINNER!");
    resultimageview.setImageResource(R.drawable.happyfaceimage);
        }else{
            resulttextview.setText("YOU ARE THE LOSER!");
            resultimageview.setImageResource(R.drawable.sadfaceimage);


        }


        trybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this,GuessActivity.class));
                finish();
            }
        });



    }
}