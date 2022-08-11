package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class VerificationActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3, edt4;
    Button verify;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        edt1 = findViewById(R.id.et_ver1);
        edt2 = findViewById(R.id.et_ver2);
        edt3 = findViewById(R.id.et_ver3);
        edt4 = findViewById(R.id.et_ver4);
        verify = findViewById(R.id.btn_verify);
        back = findViewById(R.id.btn_back);

        DigitsKeyListener dkl = DigitsKeyListener.getInstance();
        edt1.setKeyListener(dkl);
        edt2.setKeyListener(dkl);
        edt3.setKeyListener(dkl);
        edt4.setKeyListener(dkl);

        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edt1.requestFocus();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edt1.getText().toString().length() == 1){
                    edt2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edt2.getText().toString().length() == 1){
                    edt3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edt3.getText().toString().length() == 1){
                    edt4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewPassActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerificationActivity.super.finish();
            }
        });
    }
}