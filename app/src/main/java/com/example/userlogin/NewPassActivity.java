package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewPassActivity extends AppCompatActivity {

    Button resetPass;
    EditText newPass, confirmNewPass;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";
    private static final String KEY_CONFIRM_PASS = "confpass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pass);

        resetPass = findViewById(R.id.resetPass);
        newPass = findViewById(R.id.newPass);
        confirmNewPass = findViewById(R.id.confirmNewPass);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        resetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassValue = newPass.getText().toString();
                String newConfirmPassValue = confirmNewPass.getText().toString();

                String oldPass = sharedPreferences.getString(KEY_PASS, null);

                if(!oldPass.equals(newPassValue)) {
                    if(newPassValue.equals(newConfirmPassValue)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_PASS, newPassValue);
                        editor.putString(KEY_CONFIRM_PASS, newConfirmPassValue);
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(), PassChangedActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Your passwords are not match", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Your password must be different from the old one", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}