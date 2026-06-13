package com.example.loginregister;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Final extends AppCompatActivity {
    TextView t7;
    Button b56, b57;
    TextToSpeech tts;
    int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);

        t7 = findViewById(R.id.textView7);
        b56 = findViewById(R.id.button56);
        b57 = findViewById(R.id.button57);

        // Get score from Question1 static variable
        score = Question1.score;
        String scoreText = "Your Score is: " + score;
        t7.setText(scoreText);

        // Initialize TextToSpeech
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                    // Speak the score when initialized
                    tts.speak(scoreText, TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });

        b56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Final.this, Question1.class);
                startActivity(i);
                finish();
            }
        });

        b57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Final.this, Fourteenth.class);
                startActivity(j);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
