/* This activity displays the store page for the user's account. */

package com.example.vapor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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

/**
 * This activity displays the store page for the user's account.
 */
public class AccountStoreActivity extends AppCompatActivity {
    /**
     * Create a new AccountStoreActivity object.
     * @param savedInstanceState The saved instance state.
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass constructor
        super.onCreate(savedInstanceState);

        // Set the content view for the activity
        setContentView(R.layout.game_store_page);

        // Set Bottom Navigation Bar to highlight the correct button
        BottomNavigationView bnv = findViewById(R.id.bnv_navbar);

        // Set the selected item for the Bottom Navigation Bar
        bnv.setSelectedItemId(R.id.store);

        // Set Bottom Navigation Bar to change activities when a button is pressed
        bnv.setOnItemSelectedListener(item -> {
            // Get the id of the selected item
            int id = item.getItemId();

            // Convert below switch statement to if statement
            if (id == R.id.home) {
                // Create a new Intent object
                Intent home = new Intent(getApplicationContext(), AccountLibrary.class);
                // Set the flags for the Intent object
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Start the activity
                startActivity(home);
                // Override the transition animation
                overridePendingTransition(0,0);
                // Return true to indicate that the item was selected
                return true;
            } else if (id == R.id.store) {
                return true;
            } else if (id == R.id.account) {
                // Create a new Intent object
                Intent account = new Intent(getApplicationContext(), AccountPage.class);
                // Set the flags for the Intent object
                account.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Start the activity
                startActivity(account);
                // Override the transition animation
                overridePendingTransition(0,0);
                // Return true to indicate that the item was selected
                return true;
            }
            return false;
        });

        // Create a new RecyclerView object
        RecyclerView gamesListRecyclerView = findViewById(R.id.gamesListRecyclerView);

        // Create a new LinearLayoutManager object
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Set the layout manager for the RecyclerView
        gamesListRecyclerView.setLayoutManager(layoutManager);

        // Create a list of GameListItem objects
        List<GameListItem> gameListItems = new ArrayList<>();

        // Add some sample game data
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 1", "Description of Game 1"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 2", "Description of Game 2"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 3", "Description of Game 3"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 4", "Description of Game 4"));
        gameListItems.add(new GameListItem(R.drawable.masked_bandits, "Game 5", "Description of Game 5"));

        // Create a new GameListAdapter object
        GameListAdapter gameListAdapter = new GameListAdapter(gameListItems);

        // Set the adapter for the RecyclerView
        gamesListRecyclerView.setAdapter(gameListAdapter);
    }

    /**
     * This class represents a single item in the RecyclerView.
     */
    private class GameListAdapter extends RecyclerView.Adapter<GameViewHolder> {
        private final List<GameListItem> gameListItems; // The list of game data to display in the RecyclerView

        /**
         * Create a new GameListAdapter object.
         * @param gameListItems The list of game data to display in the RecyclerView.
         */
        public GameListAdapter(List<GameListItem> gameListItems) {
            this.gameListItems = gameListItems;
        }

        /**
         * This method is called when RecyclerView needs a new {@link GameViewHolder} of the given
         * type to represent an item.
         * @param parent The ViewGroup into which the new View will be added after it is bound to
         * an adapter position.
         * @param viewType The view type of the new View.
         * @return A new GameViewHolder that holds a View of the given view type.
         */
        @NonNull
        @Override
        public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate the layout for a single game item
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item,
                    parent, false);
            // Return a new GameViewHolder object
            return new GameViewHolder(itemView);
        }

        /**
         * This method is called by the RecyclerView to display the data at the specified position.
         * In this method, we update the contents of the ViewHolder to display the correct indices
         * in the list.
         */
        @Override
        public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
            // Get the element from the list at this position and replace the contents of the view
            GameListItem gameListItem = gameListItems.get(position);

            // Set the image, title, and description of the game
            holder.gameImage.setImageResource(gameListItem.getImageResourceId());

            // Set the title and description of the game
            holder.gameTitle.setText(gameListItem.getTitle());

            // Set the description of the game
            holder.gameDescription.setText(gameListItem.getDescription());

            // Set up the button to navigate to the game page
            holder.gameButton.setOnClickListener(v -> {
                // Navigate to the game page
                Intent game = new Intent(getApplicationContext(), GamePage.class);
                // Clear the back stack so that the user cannot navigate back to the store
                game.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Start the game page activity
                startActivity(game);
                // Disable the transition animation
                overridePendingTransition(0,0);
            });
        }

        /**
         * This method returns the size of the list.
         */
        @Override
        public int getItemCount() {
            return gameListItems.size();
        }
    }

    /**
     * GameViewHolder class to hold the views for a single game item in the RecyclerView.
     */
    private static class GameViewHolder extends RecyclerView.ViewHolder {

        private final ImageView gameImage; // The image of the game
        private final TextView gameTitle; // The title of the game
        private final TextView gameDescription; // The description of the game
        private final Button gameButton; // The button to navigate to the game page

        /**
         * Create a new GameViewHolder object.
         * @param itemView The view for a single game item in the RecyclerView.
         */
        public GameViewHolder(@NonNull View itemView) {
            // Call the super constructor
            super(itemView);

            // Get the views for the game item
            gameImage = itemView.findViewById(R.id.gameImage);
            gameTitle = itemView.findViewById(R.id.gameTitle);
            gameDescription = itemView.findViewById(R.id.gameDescription);
            gameButton = itemView.findViewById(R.id.gameButton);
        }
    }

    /**
     * GameListItem class to hold the data for a single game item in the RecyclerView.
     */
    private static class GameListItem {
        private final int imageResourceId; // The image resource ID of the game
        private final String title; // The title of the game
        private final String description; // The description of the game

        /**
         * Create a new GameListItem object.
         * @param imageResourceId The image resource ID of the game.
         * @param title The title of the game.
         * @param description The description of the game.
         */
        public GameListItem(int imageResourceId, String title, String description) {
            this.imageResourceId = imageResourceId;
            this.title = title;
            this.description = description;
        }

        /**
         * Get the image resource ID of the game.
         * @return The image resource ID of the game.
         */
        public int getImageResourceId() {
            return imageResourceId;
        }

        /**
         * Get the title of the game.
         * @return The title of the game.
         */
        public String getTitle() {
            return title;
        }

        /**
         * Get the description of the game.
         * @return The description of the game.
         */
        public String getDescription() {
            return description;
        }
    }
}