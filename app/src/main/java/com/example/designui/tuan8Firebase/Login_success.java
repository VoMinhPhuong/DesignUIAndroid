package com.example.designui.tuan8Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.designui.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login_success extends AppCompatActivity {
    ImageButton btnHapyy;
    ImageButton btnUnHappy;
    ImageButton btnNormal;
    DatabaseReference mDatasbase;
    int happy = 0;
    int normal = 0;
    int unhappy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);

        btnHapyy = findViewById(R.id.btnHappy);
        btnNormal = findViewById(R.id.btnNormal);
        btnUnHappy = findViewById(R.id.btnUnHappy);

        mDatasbase = FirebaseDatabase.getInstance().getReference();

        btnHapyy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatasbase.child("Happy").setValue(happy+=1);
            }
        });

        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatasbase.child("Normal").setValue(normal+=1);
            }
        });

        btnUnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatasbase.child("UnHappy").setValue(unhappy+=1);
            }
        });
    }

    public void logout(View view) {
        startActivity( new Intent(Login_success.this, MainLoginActivity.class));
    }
}