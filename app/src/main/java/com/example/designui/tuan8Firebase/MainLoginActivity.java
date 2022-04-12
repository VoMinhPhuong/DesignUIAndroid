package com.example.designui.tuan8Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.designui.R;

public class MainLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        startActivity(new Intent(MainLoginActivity.this, LoginActivity.class));
    }

    public void registerTuan8(View view) {
        startActivity(new Intent(MainLoginActivity.this, RegisterActivity.class));
    }
}