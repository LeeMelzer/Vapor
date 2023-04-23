package com.example.vapor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class vaporDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "vapor.db";
    private static final int DATABASE_VERSION = 1;

    // SQL statements to create database
    // creating table user_account
    private static final String CREATE_TABLE_ACCOUNT =
            "create table user_account (uid integer primary key autoincrement, "
<<<<<<< HEAD
                + "username text, "
                + "fName text, "
                + "lName text, "
                + "email text, "
                + "phone text, "
                + "address text, "
                + "card_number text, "
                + "card_code text, "
                + "expiration_month text, "
                + "expiration_year text);";
=======
                    + "username text, "
                    + "fName text, "
                    + "lName text, "
                    + "email text, "
                    + "phone text, "
                    + "address text, "
                    + "card_number text, "
                    + "card_code text, "
                    + "expiration_month text, "
                    + "expiration_year text);";
>>>>>>> 9724e20e0714c6c6044bfc59fc188bf01dc6637f

    // creating table library
    private static final String CREATE_TABLE_LIBRARY =
            "create table library (uid not null, gid not null, primary key(uid, gid), "
<<<<<<< HEAD
                + "foreign key (uid) references user_account(uid) on delete cascade, "
                + "foreign key (gid) references game(gid) on delete cascade);";
=======
                    + "foreign key (uid) references user_account(uid) on delete cascade, "
                    + "foreign key (gid) references game(gid) on delete cascade);";
>>>>>>> 9724e20e0714c6c6044bfc59fc188bf01dc6637f

    // creating table game
    private static final String CREATE_TABLE_GAME =
            "create table game (gid integer not null primary key autoincrement, "
<<<<<<< HEAD
                + "video text, img1 text, img2 text, img3 text, title text, description text, "
                + "long_desc text, release_date text, developer text, publisher text, total_review integer, "
                + "p_review integer);";
=======
                    + "video text, img1 text, img2 text, img3 text, title text, description text, "
                    + "long_desc text, release_date text, developer text, publisher text, total_review integer, "
                    + "p_review integer);";
>>>>>>> 9724e20e0714c6c6044bfc59fc188bf01dc6637f

    // creating table user_signin
    private static final String CREATE_TABLE_USER_SIGNIN =
            "create table user_signin (uid integer not null primary key, username text not null, "
<<<<<<< HEAD
                + "password text not null, foreign key (uid) references user_account(uid) on delete cascade);";
=======
                    + "password text not null, foreign key (uid) references user_account(uid) on delete cascade);";
>>>>>>> 9724e20e0714c6c6044bfc59fc188bf01dc6637f

    public vaporDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ACCOUNT);
        db.execSQL(CREATE_TABLE_LIBRARY);
        db.execSQL(CREATE_TABLE_GAME);
        db.execSQL(CREATE_TABLE_USER_SIGNIN);
        db.execSQL("INSERT INTO user_account VALUES (1, 'RealGamer', 'Real', 'Gamer', 'real.gamer@gamers.com', '555-555-5555', '123 Gamer St', '1234567890', '007', '03', '2027');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(vaporDBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + " which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS user_account");
        db.execSQL("DROP TABLE IF EXISTS library");
        db.execSQL("DROP TABLE IF EXISTS game");
        db.execSQL("DROP TABLE IF EXISTS user_signin");
        onCreate(db);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9724e20e0714c6c6044bfc59fc188bf01dc6637f
