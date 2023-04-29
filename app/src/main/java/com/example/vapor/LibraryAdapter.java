package com.example.vapor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;
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

        new DownloadImageFromInternet((ImageView) image).execute(game.getImageURL());
        title.setText(game.getTitle());

        return convertView;
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
                bimage= BitmapFactory.decodeStream(in);
            } catch (Exception e) {
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
