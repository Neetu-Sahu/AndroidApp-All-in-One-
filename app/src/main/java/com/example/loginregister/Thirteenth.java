package com.example.loginregister;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Thirteenth extends AppCompatActivity {
    Button b29, b30, b31;
    CameraManager cm;
    String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thirteenth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        b29 = findViewById(R.id.button29);
        b30 = findViewById(R.id.button30);
        b31 = findViewById(R.id.button31);

        cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String[] ids = cm.getCameraIdList();
            if (ids.length > 0) {
                cameraId = ids[0];
            } else {
                Toast.makeText(this, "No camera found", Toast.LENGTH_SHORT).show();
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        b29.setOnClickListener(v -> {
            if (cameraId != null) {
                try {
                    cm.setTorchMode(cameraId, true);
                    Toast.makeText(this, "Torch ON", Toast.LENGTH_SHORT).show();
                } catch (CameraAccessException e) {
                    Toast.makeText(this, "Error turning on torch", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b30.setOnClickListener(v -> {
            if (cameraId != null) {
                try {
                    cm.setTorchMode(cameraId, false);
                    Toast.makeText(this, "Torch OFF", Toast.LENGTH_SHORT).show();
                } catch (CameraAccessException e) {
                    Toast.makeText(this, "Error turning off torch", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b31.setOnClickListener(v -> {
            Intent intent = new Intent(Thirteenth.this, Tenth.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Turn off torch when leaving the activity to save battery
        try {
            if (cameraId != null) {
                cm.setTorchMode(cameraId, false);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
