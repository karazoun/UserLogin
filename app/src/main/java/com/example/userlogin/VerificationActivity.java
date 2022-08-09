package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VerificationActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3, edt4;
    Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        edt1 = findViewById(R.id.et_ver1);
        edt2 = findViewById(R.id.et_ver2);
        edt3 = findViewById(R.id.et_ver3);
        edt4 = findViewById(R.id.et_ver4);
        verify = findViewById(R.id.btn_verify);

        DigitsKeyListener dkl = DigitsKeyListener.getInstance();
        edt1.setKeyListener(dkl);
        edt2.setKeyListener(dkl);
        edt3.setKeyListener(dkl);
        edt4.setKeyListener(dkl);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewPassActivity.class);
                startActivity(intent);
            }
        });
    }
}