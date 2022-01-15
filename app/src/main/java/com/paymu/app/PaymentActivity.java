package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    TextView title;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        title = findViewById(R.id.titlee);
        back = findViewById(R.id.iconleft);

        back.setOnClickListener(v ->{
            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra("fragmentNumber",2);
            startActivity(intent);
        });

    }
}