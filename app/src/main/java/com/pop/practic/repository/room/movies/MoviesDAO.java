package com.pop.practic.repository.room.movies;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pop.practic.repository.room.notes.Note;

import java.util.List;

@Dao
public interface MoviesDAO {
    @Insert
    void insertAll(Movies movies);

    @Delete
    void deleteNote(Movies movies);

    @Query("SELECT * FROM movies")
    List<Movies> getAll();

    @Query("SELECT * FROM movies WHERE title IN(:title)")
    List<Movies> getByTitle(String title);

    @Update
    public void updateUsers(Movies... movies);
}
