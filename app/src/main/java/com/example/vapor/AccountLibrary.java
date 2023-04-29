package com.example.vapor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AccountLibrary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_library);
        BottomNavigationView bnv = findViewById(R.id.bnv_navbar);
        bnv.setOnItemSelectedListener(item -> {
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
        });

        VaporDataSource db = new VaporDataSource(AccountLibrary.this);
        try {
            Bundle extras = getIntent().getExtras();
            int uid = extras.getInt("uid");
            db.open();
            ArrayList<LibraryGame> library = db.buildLibrary(uid);
            db.close();

            /* Jank AF testing code for simple ArrayAdapter<String>
            ArrayList<String> tester = new ArrayList<>();
            for(LibraryGame game : library) { tester.add(game.getTitle()); }
            ArrayAdapter<String> testAdapter = new ArrayAdapter<>(AccountLibrary.this, R.layout.test, tester);*/

            /* Desired code to be ran, edits must be made to the adapter first UPDATE: FUCK YEAH THIS SHIT FINALLY FUCKING WORKS! */
            LibraryAdapter la = new LibraryAdapter(AccountLibrary.this, library);
            ListView libraryView = findViewById(R.id.lv_library);
            libraryView.setAdapter(la);
        } catch(Exception e) { e.printStackTrace(); }
    }
}