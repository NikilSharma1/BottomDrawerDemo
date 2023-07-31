package com.example.bottomnavigationbardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment=new HomeFragment();
        CallsFragment callsFragment=new CallsFragment();
        StatusFragment statusFragment=new StatusFragment();

        bottomNavigationView=findViewById(R.id.bottomnavview);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                }else if(item.getItemId()==R.id.calls){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,callsFragment).commit();
                }else if(item.getItemId()==R.id.status){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,statusFragment).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                }
                return true;
            }
        });
    }
}