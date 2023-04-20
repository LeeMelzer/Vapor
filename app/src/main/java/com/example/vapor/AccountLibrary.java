package com.example.vapor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AccountLibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_library);

        BottomNavigationView bnv = findViewById(R.id.bnv_navbar);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                //if(id == R.id.account)
                switch(id) {
                    case R.id.home:
                        Intent library = new Intent(AccountLibrary.this, AccountLibrary.class);
                        library.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(library);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.store:
                        Intent store = new Intent(AccountLibrary.this, AccountStoreActivity.class);
                        store.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(store);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.account:
                        Intent intent = new Intent(getApplicationContext(), AccountPage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}