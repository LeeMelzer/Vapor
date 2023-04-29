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

    // creating table library
    private static final String CREATE_TABLE_LIBRARY =
            "create table library (uid not null, gid not null, primary key(uid, gid), "
                + "foreign key (uid) references user_account(uid) on delete cascade, "
                + "foreign key (gid) references game(gid) on delete cascade);";


    // creating table game
    private static final String CREATE_TABLE_GAME =
            "create table game (gid integer not null primary key autoincrement, "

                + "video text, img1 text, img2 text, img3 text, title text, description text, "
                + "long_desc text, release_date text, developer text, publisher text, total_review integer, "
                + "p_review integer);";

    // creating table user_signin
    private static final String CREATE_TABLE_USER_SIGNIN =
            "create table user_signin (uid integer not null primary key, username text not null, "
                + "password text not null, foreign key (uid) references user_account(uid) on delete cascade);";


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
        db.execSQL("INSERT INTO game VALUES (1, '','','','','Test Title','Test Desc', 'Test Long Desc', 'Test RDATE', 'Test Dev', 'Test Pub', 0, 0);");
        db.execSQL("INSERT INTO game VALUES (2, 'https://cdn.cloudflare.steamstatic.com/steam/apps/256676426/movie480.webm?t=1481740108','https://cdn.cloudflare.steamstatic.com/steam/apps/306760/header.jpg?t=1656701014','https://cdn.cloudflare.steamstatic.com/steam/apps/306760/ss_d11a40669e54cb745dc5826e2114d67489baa075.600x338.jpg?t=1656701014','https://cdn.cloudflare.steamstatic.com/steam/apps/306760/ss_99b3fae641b8af77f530096aac9ba7a0bc19143d.600x338.jpg?t=1656701014','Obduction','A new sci-fi adventure from Cyan, the creators of Myst. Abducted far across the universe, you find yourself on a broken alien landscape with odd pieces of Earth. Explore, uncover, solve, and find a way to make it home.', " +
                "'Now also playable on Oculus Rift!\n" +
                "Note: This is a visually lush and detailed game. Playing in VR takes full advantage of higher-end systems - please refer to its minimum and recommended specs.\n" +
                "\n" +
                "From Cyan, the indie studio that brought you Myst, comes a new sci-fi adventure.\n" +
                "\n" +
                "As you walk beside the lake on a cloudy night, a curious, organic artifact falls from the starry sky and inexplicably, without asking permission, transports you across the universe. You’ve been abducted from your cozy existence and added into an alien landscape with pieces of Earth from unexpected times and places.\n" +
                "\n" +
                "The strange worlds of Obduction reveal their secrets only as you explore, discover, coax, and consider their clues. As you bask in the otherworldly beauty and explore the enigmatic landscapes, remember that the choices you make will have substantial consequences. This is your story now.\n" +
                "\n" +
                "Make it home.', 'Aug 24, 2016', 'Cyan Inc.', 'Cyan Inc.', 78, 30);");
        db.execSQL("INSERT INTO library VALUES (1,1);");
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
}

