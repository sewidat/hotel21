package com.example.hotel21.controller.user_controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.hotel21.R;

public class UpdateUser extends AppCompatActivity {

    CardView cardView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        cardView = findViewById(R.id.user_details);

        cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UserDetailsUpdate.class);

        });
    }
}