package com.example.demomovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etMovieTitle;
    EditText etGenre;
    EditText etYear;
    Spinner spinner;
    Button btnInsert;
    Button btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMovieTitle = findViewById(R.id.etMovieTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinner = findViewById(R.id.spinner);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShowList = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected rating from the Spinner
                String selectedRating = spinner.getSelectedItem().toString();

                // Get other data inputs (title, singers, year) from EditText fields
                String title = etMovieTitle.getText().toString();
                String singers = etGenre.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                // Insert the movie with the selected rating into the database
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertMovie(title, singers, year, selectedRating);

                // Show a toast to indicate that the movie has been added
                Toast.makeText(MainActivity.this, "Movie added", Toast.LENGTH_SHORT).show();
            }
        });



//                Toast.makeText(MainActivity.this,"Movie added",Toast.LENGTH_SHORT).show();
//            }
//        });
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}