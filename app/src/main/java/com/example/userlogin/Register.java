package com.example.userlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    Button btnRegister;
    EditText userName, email, password, confirmPass;
    SharedPreferences sharedPreferences;
    ImageView back;

    FirebaseAuth mAuth;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://userlogin-e0e3f-default-rtdb.firebaseio.com/");

//    private static final String SHARED_PREF_NAME = "mypref";
//    private static final String KEY_NAME = "name";
//    private static final String KEY_EMAIL = "email";
//    private static final String KEY_PASS = "password";
//    private static final String KEY_CONFIRM_PASS = "confpass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btn_real_register);
        userName = findViewById(R.id.etUserName);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        confirmPass = findViewById(R.id.etConfirmPass);
        back = findViewById(R.id.btn_back);

        mAuth = FirebaseAuth.getInstance();

//        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register.super.finish();
            }
        });
    }

    private void createUser() {
        String usernameValue = userName.getText().toString();
        String emailValue = email.getText().toString();
        String passValue = password.getText().toString();
        String confirmPassValue = confirmPass.getText().toString();


        if (!usernameValue.isEmpty() && !emailValue.isEmpty() && !passValue.isEmpty() && !confirmPassValue.isEmpty()) {
            if (passValue.equals(confirmPassValue)) {
                databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child("users").child(usernameValue).child("email").setValue(emailValue);
                        databaseReference.child("users").child(usernameValue).child("password").setValue(passValue);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                mAuth.createUserWithEmailAndPassword(emailValue, passValue).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "user registered", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "Your passwords are not match", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Fill the empty field", Toast.LENGTH_LONG).show();
        }

//        if(!usernameValue.isEmpty() && !emailValue.isEmpty() && !passValue.isEmpty() && !confirmPassValue.isEmpty()) {
//            if(passValue.equals(confirmPassValue)) {
////                        //SharedPreferences
////                        SharedPreferences.Editor editor = sharedPreferences.edit();
////                        editor.putString(KEY_NAME, usernameValue);
////                        editor.putString(KEY_EMAIL, emailValue);
////                        editor.putString(KEY_PASS, passValue);
////                        editor.putString(KEY_CONFIRM_PASS, confirmPassValue);
////                        editor.apply();
//
//                databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        //check if user not registered before
//
//                        if(snapshot.hasChild(usernameValue)){
//                            Toast.makeText(Register.this, "This user is already registered", Toast.LENGTH_LONG).show();
//                        }
//                        else {
//                            databaseReference.child("users").child(usernameValue).child("email").setValue(emailValue);
//                            databaseReference.child("users").child(usernameValue).child("password").setValue(passValue);
//
//                            Toast.makeText(getApplicationContext(), "user registered", Toast.LENGTH_LONG).show();
//
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            startActivity(intent);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            } else {
//                Toast.makeText(getApplicationContext(), "Your passwords are not match", Toast.LENGTH_LONG).show();
//            }
//        }
//        else {
//            Toast.makeText(getApplicationContext(), "Fill the empty field", Toast.LENGTH_LONG).show();
//        }
    }
}