package com.example.vapor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AccountPage extends AppCompatActivity {

    private Account currentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        currentAccount = new Account();
        initTextChangedEvents();
        initSaveButton();

        BottomNavigationView bnv = findViewById(R.id.bnv_navbar);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                //if(id == R.id.account)
                switch(id) {
                    case R.id.home:
                        Intent library = new Intent(AccountPage.this, AccountLibrary.class);
                        library.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(library);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.store:
                        Intent store = new Intent(AccountPage.this, AccountStoreActivity.class);
                        store.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(store);
                        overridePendingTransition(0,0);
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

    private void initTextChangedEvents() {
        final EditText etUsername = findViewById(R.id.username);
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setUsername(etUsername.getText().toString());
            }
        });

        final EditText etFName = findViewById(R.id.firstName);
        etFName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setFName(etFName.getText().toString());
            }
        });

        final EditText etLName = findViewById(R.id.lastName);
        etLName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setLName(etLName.getText().toString());
            }
        });

        final EditText etEmail = findViewById(R.id.eAddress);
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setEmail(etEmail.getText().toString());
            }
        });

        final EditText etPhone = findViewById(R.id.pNumber);
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setPhone(etPhone.getText().toString());
            }
        });

        final EditText etAddress = findViewById(R.id.address);
        etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setAddress(etAddress.getText().toString());
            }
        });

        final EditText etCardNumber = findViewById(R.id.cardNumber);
        etCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setCardNumber(etCardNumber.getText().toString());
            }
        });

        final EditText etCardCode = findViewById(R.id.securityCode);
        etCardCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setCardCode(etCardCode.getText().toString());
            }
        });

        final EditText etExpirationMonth = findViewById(R.id.expirationMonth);
        etExpirationMonth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setExpirationMonth(etExpirationMonth.getText().toString());
            }
        });

        final EditText etExpirationYear = findViewById(R.id.expirationYear);
        etExpirationYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Auto-generated method
            }
            @Override
            public void afterTextChanged(Editable editable) {
                currentAccount.setExpirationYear(etExpirationYear.getText().toString());
            }
        });
    }

    private void initSaveButton() {
        Button saveButton = findViewById(R.id.updateButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean wasSuccessful;
                VaporDataSource ds = new VaporDataSource(AccountPage.this);
                try {
                    ds.open();
                    if (currentAccount.getUid() == -1) {
                        wasSuccessful = ds.insertUser(currentAccount);
                        int newUid = ds.getLastUid();
                        currentAccount.setUid(newUid);
                    }
                    else {
                        wasSuccessful = ds.updateUser(currentAccount);
                    }
                    ds.close();
                }
                catch (Exception e) {
                    wasSuccessful = false;
                }
            }
        });
    }
}