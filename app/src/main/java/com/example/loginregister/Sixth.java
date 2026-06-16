package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sixth extends AppCompatActivity {
    EditText e5,e6;
    Button b13,b14;
    FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixth);
        e5=(EditText) findViewById(R.id.editTextText5);
        e6=(EditText) findViewById(R.id.editTextText6);
        e6.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b13=(Button) findViewById(R.id.button13);
        b14=(Button) findViewById(R.id.button14);
        fa=FirebaseAuth.getInstance();
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h=new Intent(Sixth.this,Third.class);
                startActivity(h);
                finish();
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e5.getText().toString().trim();
                String s2=e6.getText().toString();
                if(s1.isEmpty())
                {
                    e5.setError("please fill email");
                    return;
                }
                else
                {
                    if(s2.isEmpty())
                    {
                        e6.setError("please fill pswd");
                        return;
                    }
                    else
                    {
                        fa.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(Sixth.this, "database updated(online registered)", Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(Sixth.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(Sixth.this, "database not updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}