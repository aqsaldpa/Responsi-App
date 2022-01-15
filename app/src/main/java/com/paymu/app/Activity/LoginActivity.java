package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.room.Room;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Database.UserData;
import com.paymu.app.Data.Model.UserEntity;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private SessionLog session;
    TextView tvregister, tvrecover;
    EditText etEmail, etPassword;
    Button btnLogin;
    String channelnotif = "channelku";
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmaillog);
        etPassword = findViewById(R.id.etPasslog);
        tvregister = findViewById(R.id.tvregisthere);
        tvrecover = findViewById(R.id.tvrecovery);
        btnLogin = findViewById(R.id.btnLogin);
        session = new SessionLog(this);
        userDAO = Room.databaseBuilder(LoginActivity.this, UserData.class,"user.db").allowMainThreadQueries()
                .build().userDAO();

        tvregister.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
        });

        tvrecover.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this,RecoveryActivity.class);
            startActivity(i);
        });

        //Session
        if (session.loggedin()){
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }
        //Button
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                UserEntity userEntity = userDAO.login(email,password);
                if (userEntity != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(LoginActivity.this, "Selamat Datang , Login Berhasil", Toast.LENGTH_SHORT).show();
                    session.setLoggedin(true);
                    String name = userEntity.getEmail();
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class)
                            .putExtra("name",name);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Mohon Diisi dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}