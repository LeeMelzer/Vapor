package com.example.vapor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class AccountLibrary extends AppCompatActivity {
    private VaporDataSource db;
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
                    home.putExtra("uid", 1);
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
                    store.putExtra("uid", 1);
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
                    account.putExtra("uid", 1);
                    // Start the activity
                    startActivity(account);
                    overridePendingTransition(0,0);
                    return true;
                }
                return false;
            }
        });

        db = new VaporDataSource(AccountLibrary.this);
        try {
            Bundle extras = getIntent().getExtras();
            int uid = extras.getInt("uid");
            db.open();
            library = db.buildLibrary(uid);
            db.close();

            //ArrayAdapter<LibraryGame> adapter = new ArrayAdapter<>(AccountLibrary.this, R.layout.game_library_item, library);
            //libraryView.setAdapter(adapter);

            LibraryAdapter la = new LibraryAdapter(getApplicationContext(), library);
            for(LibraryGame g : this.library) la.add(g);
            libraryView.setAdapter(la);
        } catch(Exception e) { e.printStackTrace(); }
    }
}