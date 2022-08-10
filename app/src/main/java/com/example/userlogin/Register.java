package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button btnRegister;
    EditText userName,email, password, confirmPass;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";
    private static final String KEY_CONFIRM_PASS = "confpass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btn_real_register);
        userName = findViewById(R.id.etUserName);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        confirmPass = findViewById(R.id.etConfirmPass);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = userName.getText().toString();
                String emailValue = email.getText().toString();
                String passValue = password.getText().toString();
                String confirmPassValue = confirmPass.getText().toString();

                if(!usernameValue.isEmpty() && !emailValue.isEmpty() && !passValue.isEmpty() && !confirmPassValue.isEmpty()) {
                    if(passValue.equals(confirmPassValue)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_NAME, usernameValue);
                        editor.putString(KEY_EMAIL, emailValue);
                        editor.putString(KEY_PASS, passValue);
                        editor.putString(KEY_CONFIRM_PASS, confirmPassValue);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "user registered", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Your passwords are not match", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Fill the empty field", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}