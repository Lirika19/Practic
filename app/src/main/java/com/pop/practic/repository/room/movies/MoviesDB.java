package com.pop.practic.repository.room.movies;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDAO;

@Database(entities = {Movies.class}, version = 1)
public abstract class MoviesDB extends RoomDatabase {
    public abstract MoviesDAO moviesDAO();
}