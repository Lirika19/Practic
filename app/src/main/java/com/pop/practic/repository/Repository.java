package com.pop.practic.repository;

import android.content.Context;

import androidx.room.Room;

import com.pop.practic.repository.room.goals.Goals;
import com.pop.practic.repository.room.goals.GoalsDB;
import com.pop.practic.repository.room.movies.Movies;
import com.pop.practic.repository.room.movies.MoviesDB;
import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDB;

public class Repository {
    private Context context;
    private NoteDB noteDB;
    private GoalsDB goalsDB;
    private MoviesDB moviesDB;

    public Repository(Context context) {
        this.context = context;
        noteDB = Room.databaseBuilder(context, NoteDB.class, "database-name").allowMainThreadQueries().build();
        Note note = new Note();
        note.title = "DONUTS";
        noteDB.noteDAO().insertAll(note);
        Goals goals = new Goals();
        goalsDB = Room.databaseBuilder(context, GoalsDB.class, "database-name").allowMainThreadQueries().build();
        goalsDB.goalsDAO().insertAll(goals);
        Movies movies = new Movies();
        moviesDB = Room.databaseBuilder(context, MoviesDB.class, "database-name").allowMainThreadQueries().build();
        moviesDB.moviesDAO().insertAll(movies);
    }

    public GoalsDB getGoalsDB() {
        return goalsDB;
    }

    public NoteDB getNoteDB() {
        return noteDB;
    }

    public MoviesDB getMoviesDB() {
        return moviesDB;
    }
}
