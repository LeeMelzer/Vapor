package com.example.vapor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountButton();
    }

    private void accountButton() {
        Button account = findViewById(R.id.accountButton);
        account.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, AccountStoreActivity.class);
                intent.putExtra("uid",1);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}