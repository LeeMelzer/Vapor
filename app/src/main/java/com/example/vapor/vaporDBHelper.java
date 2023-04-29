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
        db.execSQL("INSERT INTO game VALUES (1, 'https://cdn.cloudflare.steamstatic.com/steam/apps/256850720/movie480_vp9.webm?t=1631143569'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/607080/header.jpg?t=1678138254'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/607080/ss_1fca58dd7904427261233413a1232320d6c3f005.600x338.jpg?t=1678138254'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/607080/ss_1b156e3250ef88e8a561c43e99a62cbbf5c6f26f.600x338.jpg?t=1678138254'," +
                "'Psychonauts2','Combining quirky missions and mysterious conspiracies, Psychonauts 2 is a platform-adventure game with cinematic style and tons of customizable psychic powers.\n'," +
                " 'Razputin Aquato, trained acrobat and powerful young psychic, has realized his lifelong dream of joining the international psychic espionage organization known as the Psychonauts! But these psychic super spies are in trouble. Their leader hasnt been the same since he was rescued from a kidnapping, and whats worse, theres a mole hiding in headquarters.\n" +
                "\n" +
                "Combining quirky missions and mysterious conspiracies, Psychonauts 2 is a platform-adventure game with cinematic style and tons of customizable psychic powers. Psychonauts 2 serves up danger, excitement and laughs in equal measure as players guide Raz on a journey through the minds of friends and foes on a quest to defeat a murderous psychic villain.'," +
                " 'Aug 24, 2021', 'Double Fine Productions', 'Xbox Game Studios', 97, 60);");
        db.execSQL("INSERT INTO game VALUES (2, 'https://cdn.cloudflare.steamstatic.com/steam/apps/256676426/movie480.webm?t=1481740108'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/306760/header.jpg?t=1656701014'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/306760/ss_d11a40669e54cb745dc5826e2114d67489baa075.600x338.jpg?t=1656701014'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/306760/ss_99b3fae641b8af77f530096aac9ba7a0bc19143d.600x338.jpg?t=1656701014'," +
                "'Obduction','A new sci-fi adventure from Cyan, the creators of Myst. Abducted far across the universe, you find yourself on a broken alien landscape with odd pieces of Earth. Explore, uncover, solve, and find a way to make it home.'," +
                " " +
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
        db.execSQL("INSERT INTO game VALUES (3, 'https://cdn.cloudflare.steamstatic.com/steam/apps/2036095/movie480.webm?t=1447365928'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/257510/header.jpg?t=1669116447'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/257510/ss_b42acabe63d45a11580a2949e34f305e1bd10fc7.600x338.jpg?t=1669116447'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/257510/ss_3f16d21674b27dad893ccb27b581670b5bb8043a.600x338.jpg?t=1669116447'," +
                "'The Talos Principle','The Talos Principle is a first-person puzzle game in the tradition of philosophical science fiction. Made by Croteam and written by Tom Jubert (FTL, The Swapper) and Jonas Kyratzes (The Sea Will Claim Everything).'," +
                " 'As if awakening from a deep sleep, you find yourself in a strange, contradictory world of ancient ruins and advanced technology. Tasked by your creator with solving a series of increasingly complex puzzles, you must decide whether to have faith or to ask the difficult questions: Who are you? What is your purpose? And what are you going to do about it?'," +
                " 'Dec 11, 2014', 'CroTeam', 'Devolver Digital', 95, 30);");
        db.execSQL("INSERT INTO game VALUES (4, 'https://cdn.cloudflare.steamstatic.com/steam/apps/256729816/movie480.webm?t=1537484726'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/201790/header.jpg?t=1631205565'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/201790/ss_7c1349076210cfe909a1da8deb368e8e3470fc26.600x338.jpg?t=1631205565'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/201790/ss_0f1ffc68a986967af09f274b2009d41a663bbcf7.600x338.jpg?t=1631205565'," +
                "'Orcs Must Die 2','Youve tossed, burned and sliced them by the thousands – now orcs must die more than ever before! Grab a friend and slay orcs in untold numbers in this sequel to the 2011 AIAS Strategy Game of the Year from Robot Entertainment.'," +
                " 'You’ve tossed, burned and sliced them by the thousands – now orcs must die more than ever before! Grab a friend and slay orcs in untold numbers in this sequel to the 2011 AIAS Strategy Game of the Year from Robot Entertainment.\n" +
                "\n" +
                "Leap back into the fray as a powerful War Mage or crafty Sorceress. Defend new fortresses and dwarven mines, laying waste to thousands of orcs and other monsters with a dizzying array of weapons, spells, guardians, traps, and trinkets. Play co-op with a friend and continue the battle in a brand new campaign mode, or fight to stay alive in the challenging new Endless Mode!\n" +
                "\n" +
                "Unlock new defenses and old favorites, upgrade them like never before, and unleash them on the nearest pile of slobbering orcs!'," +
                " 'Jul 30, 2012', 'Robot Entertainment', 'Robot Entertainment', 93, 14);");
        db.execSQL("INSERT INTO game VALUES (5, 'https://cdn.cloudflare.steamstatic.com/steam/apps/256892244/movie480_vp9.webm?t=1655395429'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/493520/header.jpg?t=1682601335'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/493520/ss_5ee83de8592f0b7645c07b4f6c65a210f4e271c5.600x338.jpg?t=1682601335'," +
                "'https://cdn.cloudflare.steamstatic.com/steam/apps/493520/ss_550d71cb3a80a1613085050200aa5316279e76d1.600x338.jpg?t=1682601335'," +
                "'GTFO','GTFO is an extreme cooperative horror shooter that throws you from gripping suspense to explosive action in a heartbeat. Stealth, strategy, and teamwork are necessary to survive in your deadly, underground prison. Work together or die together.'," +
                " 'Your team of prisoners is dropped into the Rundown when a new Work Order is issued by The Warden, the mysterious entity holding you captive. The Rundown is a series of expeditions, each one taking you deeper into a decayed research facility called The Complex. You descend level by level, scavenging tools and resources that help you survive in a perilous network of tunnels where gruesome creatures lurk in every shadow. Complete all the expeditions to fulfill the Work Order and clear the Rundown.'," +
                " 'Dec 9, 2021', '10 Chambers', '10 Chambers', 87, 40);");
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

