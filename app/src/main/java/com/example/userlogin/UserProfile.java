package com.example.userlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity implements RecyclerViewInterface{

    ImageView back;
    TextView welcome;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        back = findViewById(R.id.btn_back);
        welcome = findViewById(R.id.welcome);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String username = sharedPreferences.getString(KEY_NAME, null);
        welcome.setText("Welcome " + username);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("The Avengers", "The Avengers, American superhero film.", R.drawable.shield));
        items.add(new Items("The Avengers", "The Avengers, American superhero film.", R.drawable.shield));
        items.add(new Items("The Avengers", "The Avengers, American superhero film.", R.drawable.shield));
        items.add(new Items("The Avengers", "The Avengers, American superhero film.", R.drawable.shield));
        items.add(new Items("The Avengers", "The Avengers, American superhero film.", R.drawable.shield));
        items.add(new Items("The Avengers", "The Avengers, American superhero film.", R.drawable.shield));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.super.finish();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), MovieDetails.class);
        startActivity(intent);
    }

}

