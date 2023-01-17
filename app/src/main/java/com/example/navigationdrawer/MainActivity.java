package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dlMain;
    NavigationView nvMain;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dlMain = findViewById(R.id.dlMain);
        nvMain = findViewById(R.id.nvMain);
        TextView tvHeaderName = nvMain.getHeaderView(0).findViewById(R.id.tvHeaderName);
        tvHeaderName.setText("John");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this,dlMain,R.string.open,R.string.close);
        dlMain.addDrawerListener(toggle);
        toggle.syncState();
        nvMain.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id){
                case R.id.nav_account:{
                    Toast.makeText(this, "Account Clicked", Toast.LENGTH_SHORT).show();
                    AccountFragment accountFragment = new AccountFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fcMain,accountFragment);
                    transaction.commit();
                    dlMain.close();
                    break;
                }
                case R.id.nav_settings:{
                    Toast.makeText(this, "setting Clicked", Toast.LENGTH_SHORT).show();
                    SettingFragment settingFragment = new SettingFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fcMain,settingFragment);
                    transaction.commit();
                    dlMain.close();
                    break;
                }
                case R.id.nav_logout:{
                    Toast.makeText(this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                }
                case R.id.tvHeaderName:{
                    Toast.makeText(this, "Name", Toast.LENGTH_SHORT).show();
                }
                default:
                    return true;
            }
            return false;
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
           return true;
        }
        return super.onOptionsItemSelected(item);
    }
}