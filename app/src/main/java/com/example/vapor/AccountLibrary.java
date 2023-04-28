package com.example.vapor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccountLibrary extends AppCompatActivity {

    private ArrayList<LibraryGame> library;
    private ListView libraryView;
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

        library = new ArrayList<>();
        libraryView = findViewById(R.id.lv_library);
        initListView();
        setGameAdapter();
    }

    private void setGameAdapter() {
        LibraryAdapter la = new LibraryAdapter(getApplicationContext(), library);
        libraryView.setAdapter(la);
    }

    private void initListView() {
    }
}