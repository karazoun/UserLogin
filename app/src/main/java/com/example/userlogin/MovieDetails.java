package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    TextView mTextStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        mTextStatus = (TextView) findViewById(R.id.movie_descreption);

        mTextStatus.setMovementMethod(new ScrollingMovementMethod());

    }
}