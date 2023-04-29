package com.example.vapor;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LibraryAdapter extends ArrayAdapter<LibraryGame> {

    public LibraryAdapter(Context context, List<LibraryGame> games) {

        super(context, 0, games);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        LibraryGame game = getItem(position);
        if(convertView == null) { convertView = LayoutInflater.from(getContext()).inflate(R.layout.game_library_item, parent, false); }

        ImageView image = convertView.findViewById(R.id.gameImageLibrary);
        TextView title = convertView.findViewById(R.id.gameTitleLibrary);
        image.setImageURI(Uri.parse(game.getImageURL()));
        title.setText(game.getTitle());

        return convertView;
    }
}