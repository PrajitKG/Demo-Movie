package com.example.demomovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lv;
    Button btnPG13;
    ArrayList<Movie> movieList;
    ArrayList<Movie> PG13movies;
    CustomAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper db = new DBHelper(MainActivity2.this);
        movieList.clear();
        movieList.addAll(db.getMovies());
        adapter.notifyDataSetChanged();

        PG13movies.clear();
        for(int i=0; i < movieList.size(); i++){
            Movie movie = movieList.get(i);
            if("PG13".equals(movie.getRating())){
                PG13movies.add(movie);
            }
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = findViewById(R.id.lv);
        btnPG13 = findViewById(R.id.btnPG13);

        Intent intentReceived = getIntent();
        movieList = new ArrayList<Movie>();
        PG13movies = new ArrayList<Movie>();
        adapter = new CustomAdapter(this,R.layout.row, movieList);
        lv.setAdapter(adapter);

        btnPG13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.clear();
                adapter.addAll(PG13movies);
                adapter.notifyDataSetChanged();

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Movie target = movieList.get(position);
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                i.putExtra("data", target);
                startActivity(i);
            }
        });
    }
}