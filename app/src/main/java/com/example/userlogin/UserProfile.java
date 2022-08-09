package com.example.userlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity implements RecyclerViewInterface{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

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

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), MovieDetails.class);
        startActivity(intent);
    }
}
