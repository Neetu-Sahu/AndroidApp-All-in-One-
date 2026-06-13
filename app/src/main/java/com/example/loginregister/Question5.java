package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Question5 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b55;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question5);
        r1=(RadioButton) findViewById(R.id.rb5_1);
        r2=(RadioButton) findViewById(R.id.rb5_2);
        r3=(RadioButton) findViewById(R.id.rb5_3);
        r4=(RadioButton) findViewById(R.id.rb5_4);
        b55=(Button) findViewById(R.id.button55);
        b55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r3.isChecked())
                {
                    ++Question1.score;
                }
                else
                {
                    --Question1.score;
                }
                Intent i=new Intent(Question5.this, Final.class);
                startActivity(i);
                finish();
            }
        });
    }
}