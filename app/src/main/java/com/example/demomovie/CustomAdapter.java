package com.example.demomovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;
    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource,objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tvMovieTitle = rowView.findViewById(R.id.textViewMovieTitle);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);

        Movie currentItem = movieList.get(position);
        tvMovieTitle.setText(currentItem.getMovietitle());
        tvGenre.setText(currentItem.getGenre());
        tvYear.setText(String.valueOf(currentItem.getYear()));
        if ("G".equals(currentItem.getRating())) {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if ("PG".equals(currentItem.getRating())) {
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if ("PG13".equals(currentItem.getRating())) {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if ("NC16".equals(currentItem.getRating())) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if ("M18".equals(currentItem.getRating())) {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if ("R21".equals(currentItem.getRating())) {
            ivRating.setImageResource(R.drawable.rating_r21);
        }


        return rowView;
    }
}
