package com.example.designui.tuan8Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.designui.R;
import com.example.designui.tuan2.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity<mDatabase> extends AppCompatActivity {
    EditText txtName, txtEmail, txtPass1, txtPass2;
    Button btnRegis;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = findViewById(R.id.txtYourName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass1 = findViewById(R.id.txtPass1);
        txtPass2 = findViewById(R.id.txtPass2);
        btnRegis = findViewById(R.id.btnRegister);

        fAuth = FirebaseAuth.getInstance();

//        if (fAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
//            finish();
//        }

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password2 = txtPass2.getText().toString().trim();
                String password1 = txtPass1.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    txtEmail.setError("Email không được rỗng");
                    return;
                }
                if(TextUtils.isEmpty(password1)){
                    txtPass1.setError("Pass không được rỗng");
                    return;
                }
                if(password1.length() < 6){
                    txtPass1.setError("Pass có độ dài phải >=6");
                }
                if(TextUtils.isEmpty(password2)){
                    txtPass2.setError("Vui lòng nhập lại pass");
                    return;
                }
                if(!password1.equals(password2)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đúng mật khẩu", Toast.LENGTH_SHORT).show();
                }


                fAuth.createUserWithEmailAndPassword(email, password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Register success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainLoginActivity.class));
                        } else {
                            Toast.makeText(RegisterActivity.this, "Đăng ký không thành công !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}