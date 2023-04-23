package com.example.vapor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class VaporDataSource {

    private SQLiteDatabase database;
    private vaporDBHelper dbHelper;

    public VaporDataSource(Context context) {
        dbHelper = new vaporDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertUser(Account a) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("username", a.getUsername());
            initialValues.put("fName", a.getFName());
            initialValues.put("lName", a.getLName());
            initialValues.put("email", a.getEmail());
            initialValues.put("phone", a.getPhone());
            initialValues.put("address", a.getAddress());
            initialValues.put("card_number", a.getCardNumber());
            initialValues.put("card_code", a.getCardCode());
            initialValues.put("expiration_month", a.getExpirationMonth());
            initialValues.put("expiration_year", a.getExpirationYear());

            didSucceed = database.insert("user_account", null, initialValues) > 0;
        }
        catch (Exception e) {
            // will return false if there is an exception
        }
        return didSucceed;
    }

    public boolean updateUser(Account a) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) a.getUid();
            ContentValues updateValues = new ContentValues();

            updateValues.put("username", a.getUsername());
            updateValues.put("fName", a.getFName());
            updateValues.put("lName", a.getLName());
            updateValues.put("email", a.getEmail());
            updateValues.put("phone", a.getPhone());
            updateValues.put("address", a.getAddress());
            updateValues.put("card_number", a.getCardNumber());
            updateValues.put("card_code", a.getCardCode());
            updateValues.put("expiration_month", a.getExpirationMonth());
            updateValues.put("expiration_year", a.getExpirationYear());

            didSucceed = database.update("user_account", updateValues, "uid=" + rowId, null) > 0;
            if (didSucceed) {
                System.out.println("Successfully updated");
            }
        }
        catch (Exception e) {
            // will return false if there is an exception
        }
        return didSucceed;
    }

    public int getLastUid() {
        int lastUid;
        try {
            String query = "select MAX(uid) from user_account";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastUid = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e) {
            lastUid = -1;
        }
        return lastUid;
    }
}

