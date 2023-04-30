package com.example.vapor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class GamePage extends AppCompatActivity {

    private GamePageOBJ game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        Bundle extras = getIntent().getExtras();
        int uid = extras.getInt("uid");
        int gid = extras.getInt("gid");
        initGamePage(gid);
        initBuyButton(uid, gid);

        VideoView vid = findViewById(R.id.trailer_video);
        // video finish listener
        vid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                vid.setVisibility(View.INVISIBLE);
                rotateImages(1);
            }
        });

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
    }

    private void rotateImages(int current) {
        ImageView screen1 = findViewById(R.id.Screenshot1);
        ImageView screen2 = findViewById(R.id.Screenshot2);
        ImageView screen3 = findViewById(R.id.Screenshot3);
        if (current == 1) {
            screen1.setVisibility(View.VISIBLE);
            screen2.setVisibility(View.INVISIBLE);
            screen3.setVisibility(View.INVISIBLE);
            screen1.requestFocus();
            delay(2);
        } else if (current == 2) {
            screen1.setVisibility(View.INVISIBLE);
            screen2.setVisibility(View.VISIBLE);
            screen3.setVisibility(View.INVISIBLE);
            screen2.requestFocus();
            delay(3);
        } else if (current == 3) {
            screen1.setVisibility(View.INVISIBLE);
            screen2.setVisibility(View.INVISIBLE);
            screen3.setVisibility(View.VISIBLE);
            screen3.requestFocus();
            delay(1);
        }
    }

    private void delay(int next) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                rotateImages(next);
            }
        }, 5000);
    }

    //add an object to the library db :: db.execSQL("INSERT INTO library VALUES (1,1);");
    private void initBuyButton(int uid, int gid) {
        Button buyButton = findViewById(R.id.purchasebutton);
        buyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean wasSuccessful;
                VaporDataSource ds = new VaporDataSource(GamePage.this);
                try {
                    ds.open();
                    wasSuccessful = ds.insertLibrary(uid, gid);
                    ds.close();
                } catch (Exception e) {
                    wasSuccessful = false;
                }
                if (wasSuccessful) {
                    buyButton.setText("Added to Library");
                } else {
                    buyButton.setText("Owned");
                }
            }
        });
    }

    private void initGamePage(int gid) {
        VaporDataSource ds = new VaporDataSource(GamePage.this);
        try {
            ds.open();
            game = ds.getGame(gid);
            ds.close();
        } catch (Exception e) {
            Toast.makeText(this, "Load Game Failed", Toast.LENGTH_LONG).show();
        }

        TextView title = findViewById(R.id.title_textview);
        TextView description = findViewById(R.id.description_string_textview);
        TextView about = findViewById(R.id.about_textview);
        TextView score = findViewById(R.id.score_string_textview);
        Button price = findViewById(R.id.purchasebutton);
        TextView developer = findViewById(R.id.dev_string_textview);
        TextView publisher = findViewById(R.id.publisher_string_textview);
        TextView date = findViewById(R.id.date_string_textview);
        VideoView vid = findViewById(R.id.trailer_video);
        ImageView screen1 = findViewById(R.id.Screenshot1);
        ImageView screen2 = findViewById(R.id.Screenshot2);
        ImageView screen3 = findViewById(R.id.Screenshot3);

        title.setText(game.getTitle());
        description.setText(game.getDesc());
        about.setText(game.getAbout());
        score.setText(game.getTotalreview() + "%");
        price.setText("Buy: $" + game.getPreview());
        developer.setText(game.getDeveloper());
        publisher.setText(game.getPublisher());
        date.setText(game.getDate());



        new DownloadImageFromInternet((ImageView) screen1).execute(game.getScreenshot1());
        new DownloadImageFromInternet((ImageView) screen2).execute(game.getScreenshot2());
        new DownloadImageFromInternet((ImageView) screen3).execute(game.getScreenshot3());

        vid.setVideoURI(Uri.parse(game.getVideo()));
        vid.setMediaController(new MediaController(this));
        vid.requestFocus();
        vid.start();

    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView=imageView;
        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage=BitmapFactory.decodeStream(in);
            } catch (Exception e) {
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

}

