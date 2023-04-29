package com.example.vapor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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

    public Account getUserAccount(int uid) {
        Account account = new Account();
        String query = "SELECT * FROM user_account WHERE uid =" + uid;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            account.setUid(cursor.getInt(0));
            account.setUsername(cursor.getString(1));
            account.setFName(cursor.getString(2));
            account.setLName(cursor.getString(3));
            account.setEmail(cursor.getString(4));
            account.setPhone(cursor.getString(5));
            account.setAddress(cursor.getString(6));
            account.setCardNumber(cursor.getString(7));
            account.setCardCode(cursor.getString(8));
            account.setExpirationMonth(cursor.getString(9));
            account.setExpirationYear(cursor.getString(10));

            cursor.close();
        }
        return account;
    }

    public ArrayList<LibraryGame> buildLibrary(int uid) {
        ArrayList<Integer> gids = new ArrayList<>();
        String query = "SELECT * FROM library WHERE uid = " + uid;
        Cursor idCursor = database.rawQuery(query, null);
        boolean items = idCursor.moveToFirst();
        while(items) {
            int gameID = idCursor.getInt(1);
            gids.add(gameID);
            items = idCursor.moveToNext();
        }

        idCursor.close();

        return getGames(gids);
    }

    private ArrayList<LibraryGame> getGames(ArrayList<Integer> gids) {
        ArrayList<LibraryGame> games = new ArrayList<>();
        for(Integer gid : gids)
        {
            String query = "SELECT img1, title FROM game WHERE gid= " + gid;
            Cursor gameCursor = database.rawQuery(query, null);

            if(gameCursor.moveToFirst()) {
                String img = gameCursor.getString(0);
                String title = gameCursor.getString(1);
                LibraryGame game = new LibraryGame(img, title);
                games.add(game);
            }

            gameCursor.close();
        }

        return games;
    }

    public GamePageOBJ getGame(int gid) {
        GamePageOBJ game = new GamePageOBJ();
        String query = "SELECT * FROM game WHERE gid =" + gid;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {

            game.setGid(cursor.getInt(0));
            game.setVideo(cursor.getString(1));
            game.setScreenshot1(cursor.getString(2));
            game.setScreenshot2(cursor.getString(3));
            game.setScreenshot3(cursor.getString(4));
            game.setTitle(cursor.getString(5));
            game.setDesc(cursor.getString(6));
            game.setAbout(cursor.getString(7));
            game.setDate(cursor.getString(8));
            game.setDeveloper(cursor.getString(9));
            game.setPublisher(cursor.getString(10));
            game.setTotalreview(cursor.getInt(11));
            game.setPreview(cursor.getInt(12));

            cursor.close();
        }
        return game;
    }

    //db.execSQL("INSERT INTO library VALUES (1,1);");
    public boolean insertLibrary(int uid, int gid) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("uid", uid);
            initialValues.put("gid", gid);

            didSucceed = database.insert("library", null, initialValues) > 0;
        }
        catch (Exception e) {
            // will return false if there is an exception
        }
        return didSucceed;
    }
}

