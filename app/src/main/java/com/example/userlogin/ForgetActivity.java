package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetActivity extends AppCompatActivity {

    TextView login;
    Button sendCode;
    EditText etForget;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        login = findViewById(R.id.txt_login);
        sendCode = findViewById(R.id.btn_sendCode);
        etForget = findViewById(R.id.et_email_forget);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = etForget.getText().toString();

                String registeredEmail = sharedPreferences.getString(KEY_EMAIL, null);

                if(emailValue.equals(registeredEmail)) {
                    Intent intent = new Intent(getApplicationContext(), VerificationActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}