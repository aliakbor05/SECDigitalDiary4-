package com.example.android.secdigitaldiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView SECWebcardView,infocardView,notescardView,resultcardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SECWebcardView = findViewById(R.id.SECWebsiteID);
        infocardView = findViewById(R.id.TeachersInfoID);
        notescardView = findViewById(R.id.NotesID);
        resultcardView = findViewById(R.id.ResultID);

        SECWebcardView.setOnClickListener(this);
        infocardView.setOnClickListener(this);
        notescardView.setOnClickListener(this);
        resultcardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.SECWebsiteID){

            Intent intent = new Intent(MainActivity.this,SECWebsite.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.TeachersInfoID){

            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.NotesID){

            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.ResultID){

        }
    }
}
