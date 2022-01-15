package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.room.Room;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.lights.Light;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
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

import org.w3c.dom.Text;

public class RecoveryActivity extends AppCompatActivity {
    Button btnSendEmail;
    ImageView btnBack;
    TextView title;
    String channelnotif = "channelku";
    UserDAO userDAO;
    EditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        btnSendEmail = findViewById(R.id.btmSemdEmail);
        etEmail = findViewById(R.id.etEmailRecov);
        title = findViewById(R.id.titlee);
        title.setText("Recovery Activity");
        btnBack = findViewById(R.id.iconleft);
        btnBack.setOnClickListener(view -> {
            Intent i = new Intent(RecoveryActivity.this, LoginActivity.class);
            startActivity(i);
        });
        userDAO = Room.databaseBuilder(RecoveryActivity.this, UserData.class,"user.db").allowMainThreadQueries()
                .build().userDAO();


        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(RecoveryActivity.this,"Testing Notif");
                builder.setContentTitle("Email telah dikirimkan");
                builder.setContentText("Mohon ditunggu :)");
                builder.setSmallIcon(R.drawable.ic_baseline_check_circle_24);
                builder.setAutoCancel(true);

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel notificationChannel = new
                            NotificationChannel(channelnotif, "contoh channel", importance);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(Color.RED);
                    builder.setChannelId(channelnotif);
                    assert mNotificationManager != null;
                    mNotificationManager.createNotificationChannel(notificationChannel);
                }
                assert mNotificationManager != null;
                mNotificationManager.notify((int) System.currentTimeMillis(), builder.build());
                String email = etEmail.getText().toString().trim();
                UserEntity userEntity = userDAO.recovery(email);
                if (userEntity !=null && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Intent i = new Intent (RecoveryActivity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(RecoveryActivity.this, "Email belum didaftarkan", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}