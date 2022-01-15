package com.paymu.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Database.UserData;
import com.paymu.app.Data.Model.UserEntity;
import com.paymu.app.R;

public class RegisterActivity extends AppCompatActivity {
    TextView title;
    EditText etmail , etpass,etconfpass;
    Button btnRegister;
    ImageView btnback;
    UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        title = findViewById(R.id.titlee);
        title.setText("Register Activity");

        etmail = findViewById(R.id.etEmailRegister);
        etpass = findViewById(R.id.etPassReg);
        etconfpass = findViewById(R.id.etConfirmPass);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etmail.getText().toString().trim();
                String pass = etpass.getText().toString().trim();
                String confirm = etconfpass.getText().toString().trim();

                if (pass.length() == 0 && (confirm.length()== 0)){
                    etpass.setError("Mohon isi password");
                }
                else if (!pass.equals(confirm)){
                    etconfpass.setError("Konfirmasi Password Anda Salah");
                }
                else if (pass.equals(confirm) && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    UserEntity userEntity = new UserEntity(email,pass);
                    userDAO.Register(userEntity);
                    Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegisterActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Mohon Masukkan Email dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnback = findViewById(R.id.iconleft);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        userDAO = Room.databaseBuilder(RegisterActivity.this, UserData.class,"user.db").allowMainThreadQueries()
                .build().userDAO();
    }
}