package com.example.loginregister;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    ProgressBar progressBar;
    TextView loadingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        LinearLayout logoContainer = findViewById(R.id.logoContainer);
        View glowEffect = findViewById(R.id.glowEffect);
        progressBar = findViewById(R.id.splashProgress);
        loadingText = findViewById(R.id.loadingText);

        // 1. Entrance Animation for Logo and Text
        Animation entranceAnim = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        logoContainer.startAnimation(entranceAnim);

        // 2. Subtle Pulse Animation for the Background Glow
        Animation pulseAnim = AnimationUtils.loadAnimation(this, R.anim.glow_pulse);
        glowEffect.startAnimation(pulseAnim);

        // 3. Animate the ProgressBar and Update Percentage Text
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(4000);
        animator.addUpdateListener(animation -> {
            int progress = (int) animation.getAnimatedValue();
            progressBar.setProgress(progress);
            loadingText.setText("Loading... " + progress + "%");
        });
        animator.start();

        // 4. Transition to MainActivity after 4 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                
                // Swift fade out transition
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish();
            }
        }, 4000);
    }
}
