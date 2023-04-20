package com.example.vapor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class AccountStoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_store_page);

        // Set Bottom Navigation Bar to highlight the correct button
        BottomNavigationView bnv = findViewById(R.id.bnv_navbar);
        bnv.setSelectedItemId(R.id.store);

        // Set Bottom Navigation Bar to change activities when a button is pressed
        bnv.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id) {
                    case R.id.home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.store:
                        return true;

                    case R.id.account:
                        Intent intent2 = new Intent(getApplicationContext(), AccountPage.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

        // Find the RecyclerView and set up the layout manager
        RecyclerView gamesListRecyclerView = findViewById(R.id.gamesListRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        gamesListRecyclerView.setLayoutManager(layoutManager);

        // Set up the adapter with some sample game data
        List<GameListItem> gameListItems = new ArrayList<>();
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 1", "Description of Game 1"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 2", "Description of Game 2"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 3", "Description of Game 3"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 4", "Description of Game 4"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 5", "Description of Game 5"));
        GameListAdapter gameListAdapter = new GameListAdapter(gameListItems);
        gamesListRecyclerView.setAdapter(gameListAdapter);
    }

    // GameListAdapter class to display game data in the RecyclerView
    private static class GameListAdapter extends RecyclerView.Adapter<GameViewHolder> {

        private final List<GameListItem> gameListItems;

        public GameListAdapter(List<GameListItem> gameListItems) {
            this.gameListItems = gameListItems;
        }

        @NonNull
        @Override
        public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item, parent, false);
            return new GameViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
            GameListItem gameListItem = gameListItems.get(position);
            holder.gameImage.setImageResource(gameListItem.getImageResourceId());
            holder.gameTitle.setText(gameListItem.getTitle());
            holder.gameDescription.setText(gameListItem.getDescription());
            holder.gameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click here
                }
            });
        }

        @Override
        public int getItemCount() {
            return gameListItems.size();
        }
    }

    // GameViewHolder class to hold the view elements for a single game item in the RecyclerView
    private static class GameViewHolder extends RecyclerView.ViewHolder {

        private final ImageView gameImage;
        private final TextView gameTitle;
        private final TextView gameDescription;
        private final Button gameButton;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.gameImage);
            gameTitle = itemView.findViewById(R.id.gameTitle);
            gameDescription = itemView.findViewById(R.id.gameDescription);
            gameButton = itemView.findViewById(R.id.gameButton);
        }
    }

    // GameListItem class to hold the data for a single game item in the RecyclerView
    private static class GameListItem {
        private final int imageResourceId;
        private final String title;
        private final String description;

        public GameListItem(int imageResourceId, String title, String description) {
            this.imageResourceId = imageResourceId;
            this.title = title;
            this.description = description;
        }

        public int getImageResourceId() {
            return imageResourceId;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}