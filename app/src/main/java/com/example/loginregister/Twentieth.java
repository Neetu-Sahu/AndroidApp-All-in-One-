package com.example.loginregister;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Twentieth extends AppCompatActivity {
    EditText ePhone;
    Button bCall, bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twentieth);

        ePhone = findViewById(R.id.editTextPhone);
        bCall = findViewById(R.id.buttonCall);
        bBack = findViewById(R.id.buttonBack20);

        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = ePhone.getText().toString();
                if (number.isEmpty()) {
                    Toast.makeText(Twentieth.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + number));
                    startActivity(i);
                }
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Twentieth.this, Tenth.class);
                startActivity(i);
                finish();
            }
        });
    }
}
