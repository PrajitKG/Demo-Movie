package com.example.demomovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity {
    EditText etMovieID;
    EditText etMovieTitle;
    EditText etGenre;
    EditText etYear;
    Spinner spinner;
    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;
    Movie data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        etMovieID = findViewById(R.id.etMovieID);
        etMovieTitle = findViewById(R.id.etMovieTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinner = findViewById(R.id.spinner);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent intentReceived1 = getIntent();
        data = (Movie) intentReceived1.getSerializableExtra("data");
        etMovieID.setText("Movie ID:" + data.getId());
        etMovieTitle.setText(data.getMovietitle());
        etGenre.setText(data.getGenre());
        etYear.setText(String.valueOf(data.getYear()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected rating from the Spinner
                String selectedRating = spinner.getSelectedItem().toString();

                // Update the "data" object with the selected rating
                data.setMovietitle(etMovieTitle.getText().toString());
                data.setGenre(etGenre.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setRating(selectedRating);

                // Now, you can perform the update operation in the database using the updated "data" object
                // Assuming you have a DBHelper class with an "updateMovie" method
                DBHelper db = new DBHelper(MainActivity3.this);
                db.updateMovie(data);
                db.close();
                finish();


            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity3.this);
                dbh.deleteMovie(data.getId());
                finish();


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}