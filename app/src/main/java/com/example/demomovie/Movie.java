package com.example.demomovie;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String movietitle;
    private String genre;
    private int year;
    private String rating;

    public Movie(int id, String movietitle, String genre, int year, String rating) {
        this.id = id;
        this.movietitle = movietitle;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    @NonNull
    @Override
    public String toString() {
        return id + "\n" + movietitle + "\n" + genre + "\n" + year + "\n" + rating ;
    }
}
