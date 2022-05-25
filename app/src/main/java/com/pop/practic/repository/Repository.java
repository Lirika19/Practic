package com.pop.practic.repository;

import android.content.Context;

import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pop.practic.repository.room.goals.Goals;
import com.pop.practic.repository.room.goals.GoalsDB;
import com.pop.practic.repository.room.movies.Movies;
import com.pop.practic.repository.room.movies.MoviesDB;
import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDB;
import com.pop.practic.repository.room.todolist.ToDoRef;
import com.pop.practic.repository.room.todolist.ToDoRefDB;

public class Repository {
    private Context context;
    private NoteDB noteDB;
    private GoalsDB goalsDB;
    private MoviesDB moviesDB;
    private ToDoRefDB todorefDB;

    public Repository(Context context) {
        this.context = context;
        Goals goals = new Goals();
        goalsDB = Room.databaseBuilder(context, GoalsDB.class, "database-name2").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        goalsDB.goalsDAO().insertAll(goals);
        Movies movies = new Movies();
        moviesDB = Room.databaseBuilder(context, MoviesDB.class, "database-name3").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        moviesDB.moviesDAO().insertAll(movies);
        noteDB = Room.databaseBuilder(context,NoteDB.class, "databasenote-name").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        Note note =  new Note();
        todorefDB = Room.databaseBuilder(context,ToDoRefDB.class, "databasetodo-name4").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        List<Note> notes = new ArrayList<>() ;
        ToDoRef todoref =  new ToDoRef();
        List<ToDoRef> todo = new ArrayList<>();
        notes = noteDB.noteDAO().getByTitle("Nothing");
        todo = todorefDB.todorefDAO().getByTitle("Nothing");
        for (Note n:notes){
            noteDB.noteDAO().deleteNote(n);
        }
        for (ToDoRef n:todo){
            todorefDB.todorefDAO().deleteNote(n);
        }
        note.title ="Nothing";
        noteDB.noteDAO().insertAll(note);
        todoref.title ="Nothing";
        todorefDB.todorefDAO().insertAll(todoref);
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
    public ToDoRefDB getToDoRefDB(){
        return todorefDB;

    }
}
