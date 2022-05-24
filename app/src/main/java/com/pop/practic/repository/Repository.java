package com.pop.practic.repository;

import android.content.Context;

import androidx.room.Room;

import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDB;
import com.pop.practic.repository.room.todolist.ToDoRef;
import com.pop.practic.repository.room.todolist.ToDoRefDB;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private Context context;
    private NoteDB noteDB;
    private ToDoRefDB todorefDB;
    public Repository(Context context){
        this.context = context;
        noteDB = Room.databaseBuilder(context,NoteDB.class, "database-name").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        Note note =  new Note();
        todorefDB = Room.databaseBuilder(context,ToDoRefDB.class, "database-name").allowMainThreadQueries().fallbackToDestructiveMigration().build();
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

    public NoteDB getNoteDB(){
        return noteDB;
    }
    public ToDoRefDB getToDoRefDB(){
        return todorefDB;
    }
}
