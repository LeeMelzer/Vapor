package com.example.vapor;

import android.content.Context;
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class GameStorePagerAdapter extends RecyclerView.Adapter<GameStorePagerAdapter.GameRowViewHolder> {

    private final List<List<Game>> mGameRows;
    private final Context mContext;

    public GameStorePagerAdapter(Context context, List<List<Game>> gameRows) {
        mContext = context;
        mGameRows = gameRows;
    }

    @NonNull
    @Override
    public GameRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.game_row_layout, parent, false);
        return new GameRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameRowViewHolder holder, int position) {
        List<Game> gameRow = mGameRows.get(position);
        holder.gameIcon1.setImageResource(gameRow.get(0).getIconResourceId());
        holder.gameTitle1.setText(gameRow.get(0).getTitle());
        holder.purchaseButton1.setOnClickListener(v -> {
            // Handle purchase button click for game 1
        });
        if (gameRow.size() > 1) {
            holder.gameIcon2.setImageResource(gameRow.get(1).getIconResourceId());
            holder.gameTitle2.setText(gameRow.get(1).getTitle());
            holder.purchaseButton2.setOnClickListener(v -> {
                // Handle purchase button click for game 2
            });
            holder.gameIcon2.setVisibility(View.VISIBLE);
            holder.gameTitle2.setVisibility(View.VISIBLE);
            holder.purchaseButton2.setVisibility(View.VISIBLE);
        } else {
            holder.gameIcon2.setVisibility(View.INVISIBLE);
            holder.gameTitle2.setVisibility(View.INVISIBLE);
            holder.purchaseButton2.setVisibility(View.INVISIBLE);
        }
        if (gameRow.size() > 2) {
            holder.gameIcon3.setImageResource(gameRow.get(2).getIconResourceId());
            holder.gameTitle3.setText(gameRow.get(2).getTitle());
            holder.purchaseButton3.setOnClickListener(v -> {
                // Handle purchase button click for game 3
            });
            holder.gameIcon3.setVisibility(View.VISIBLE);
            holder.gameTitle3.setVisibility(View.VISIBLE);
            holder.purchaseButton3.setVisibility(View.VISIBLE);
        } else {
            holder.gameIcon3.setVisibility(View.INVISIBLE);
            holder.gameTitle3.setVisibility(View.INVISIBLE);
            holder.purchaseButton3.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mGameRows.size();
    }

    public static class GameRowViewHolder extends RecyclerView.ViewHolder {

        ImageView gameIcon1;
        TextView gameTitle1;
        Button purchaseButton1;

        ImageView gameIcon2;
        TextView gameTitle2;
        Button purchaseButton2;

        ImageView gameIcon3;
        TextView gameTitle3;
        Button purchaseButton3;

        public GameRowViewHolder(View itemView) {
            super(itemView);
            gameIcon1 = itemView.findViewById(R.id.gameIcon1);
            gameTitle1 = itemView.findViewById(R.id.gameTitle1);
            purchaseButton1 = itemView.findViewById(R.id.purchaseButton1);
            gameIcon2 = itemView.findViewById(R.id.gameIcon2);
            gameTitle2 = itemView.findViewById(R.id.gameTitle2);
            purchaseButton2 = itemView.findViewById(R.id.purchaseButton2);
            gameIcon3 = itemView.findViewById(R.id.gameIcon3);
            gameTitle3 = itemView.findViewById(R.id.gameTitle3);
            purchaseButton3 = itemView.findViewById(R.id.purchaseButton3);
        }
    }
}