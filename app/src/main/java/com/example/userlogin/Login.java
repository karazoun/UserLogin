package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnRealLogin;
    TextView register, forget;
    SharedPreferences sharedPreferences;
    ImageView back;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email_log);
        etPassword = findViewById(R.id.et_Password_log);
        btnRealLogin = findViewById(R.id.btn_real_login);
        register = findViewById(R.id.reg);
        forget = findViewById(R.id.txt_forget);
        back = findViewById(R.id.btn_back);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        btnRealLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = etEmail.getText().toString();
                String passValue = etPassword.getText().toString();

                String registeredEmail = sharedPreferences.getString(KEY_EMAIL, null);
                String registeredPass = sharedPreferences.getString(KEY_PASS, null);

                if(emailValue.equals(registeredEmail) && passValue.equals(registeredPass)) {
                    Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgetActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.super.finish();
            }
        });
    }
}