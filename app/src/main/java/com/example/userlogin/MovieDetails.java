package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetails extends AppCompatActivity {

    TextView mTextStatus;
    ImageView back;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        mTextStatus = findViewById(R.id.movie_descreption);
        back = findViewById(R.id.btn_back);
        welcome = findViewById(R.id.welcome);

        mTextStatus.setMovementMethod(new ScrollingMovementMethod());

        welcome.setText("The Avengers");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieDetails.super.finish();
            }
        });
    }
}