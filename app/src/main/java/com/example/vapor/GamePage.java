package com.example.vapor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class GamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        BottomNavigationView bnv = findViewById(R.id.bnv_navbar);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                //if(id == R.id.account)
                switch(id) {
                    case R.id.home:
                        Intent library = new Intent(getApplicationContext(), AccountLibrary.class);
                        library.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(library);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.store:
                        System.out.println("Store button pressed");
                        return true;

                    case R.id.account:
                        Intent account = new Intent(getApplicationContext(), AccountPage.class);
                        account.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(account);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}