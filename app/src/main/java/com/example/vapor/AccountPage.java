package com.example.vapor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AccountPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);

        BottomNavigationView bnv = findViewById(R.id.bnv_navbar);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Using the id, we can determine which item was selected
                if (id == R.id.home) {
                    // Create a new Intent object
                    Intent home = new Intent(getApplicationContext(), AccountLibrary.class);
                    // Set the flags for the Intent object
                    home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    // Start the activity
                    startActivity(home);
                    overridePendingTransition(0,0);
                    return true;
                }
                else if (id == R.id.store) {
                    // Create a new Intent object
                    Intent store = new Intent(getApplicationContext(), AccountStoreActivity.class);
                    // Set the flags for the Intent object
                    store.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    // Start the activity
                    startActivity(store);
                    overridePendingTransition(0,0);
                    return true;
                }
                else if (id == R.id.account) {
                    // Create a new Intent object
                    Intent account = new Intent(getApplicationContext(), AccountPage.class);
                    // Set the flags for the Intent object
                    account.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    // Start the activity
                    startActivity(account);
                    overridePendingTransition(0,0);
                    return true;
                }
                return false;
            }
        });
    }

    public void accountToLibrary(View view) {
        Intent intent = new Intent (AccountPage.this, AccountLibrary.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}