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

public class Question3 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b53;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question3);
        r1=(RadioButton) findViewById(R.id.rb3_1);
        r2=(RadioButton) findViewById(R.id.rb3_2);
        r3=(RadioButton) findViewById(R.id.rb3_3);
        r4=(RadioButton) findViewById(R.id.rb3_4);
        b53=(Button) findViewById(R.id.button53);
        b53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r2.isChecked())
                {
                    ++Question1.score;
                }
                else
                {
                    --Question1.score;
                }
                Intent i=new Intent(Question3.this, Question4.class);
                startActivity(i);
                finish();
            }
        });
    }
}