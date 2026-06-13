package com.example.loginregister;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fourteenth extends AppCompatActivity {
    Button b34,b35,b36,b44,b48,b49;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourteenth);
        b34=(Button) findViewById(R.id.button34);
        b35=(Button) findViewById(R.id.button35);
        b36=(Button) findViewById(R.id.button36);
        b44=(Button) findViewById(R.id.button44);
        b48=(Button) findViewById(R.id.button48);
        b49=(Button) findViewById(R.id.button49);
        b34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fourteenth.this, Fifteenth.class);
                startActivity(i);
                finish();
            }
        });
        b35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Fourteenth.this, Sixteenth.class);
                startActivity(j);
                finish();
            }
        });
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(Fourteenth.this, Seventeenth.class);
                startActivity(k);
                finish();
            }
        });
        b44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y=new Intent(Fourteenth.this, Ninth.class);
                startActivity(y);
                finish();
            }
        });
        b48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fourteenth.this, TwentyThird.class);
                startActivity(i);
                finish();
            }
        });
        b49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fourteenth.this, TwentyFourth.class);
                startActivity(i);
                finish();
            }
        });
    }
}