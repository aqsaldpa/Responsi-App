package com.paymu.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.paymu.app.R;

public class ProfileActivity extends AppCompatActivity {
    TextView title;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        title = findViewById(R.id.titlee);
        title.setText("Profile");
        back = findViewById(R.id.iconleft);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra("fragmentNumber",1);
            startActivity(intent);
        });
    }
}