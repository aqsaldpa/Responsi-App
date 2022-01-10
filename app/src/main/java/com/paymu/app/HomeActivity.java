package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.paymu.app.Fragment.FragmentHistory;
import com.paymu.app.Fragment.FragmentHome;
import com.paymu.app.Fragment.FragmentPayment;
import com.paymu.app.Fragment.FragmentSetting;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    SessionLog session;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    TextView tvname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            fragmentManager = getSupportFragmentManager();
            FragmentHome homeFragment = new FragmentHome();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, homeFragment)
                    .commit();
        }
        tvname = findViewById(R.id.tvname);
        session = new SessionLog(this);
        if (session.loggedin()){
            String name = getIntent().getStringExtra("name");
            tvname.setText(name);
        }
        String name = getIntent().getStringExtra("name");
        tvname.setText(name);
        session.setLoggedin(true);


        bottomNavigationView = findViewById(R.id.bottomnav);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.Home:
                    fragment = new FragmentHome();
                    break;

                case R.id.payment:
                    fragment = new FragmentPayment();
                    break;
                case R.id.History:
                    fragment = new FragmentHistory();
                    break;
                case R.id.Setting:
                    fragment = new FragmentSetting();
                    break;
            }
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout1) {
            session.setLoggedin(false);
            finish();
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            Toast.makeText(this, "Selamat Tinggal", Toast.LENGTH_SHORT).show();

        }
        return true;
        }
    }