package br.com.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.provaandroid.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }
}