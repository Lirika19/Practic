package com.pop.practic.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Repository {
    private Context context;
    private NoteDB noteDB;
    public Repository(Context context){
        this.context = context;
        noteDB = Room.databaseBuilder(context,NoteDB.class, "database-name").allowMainThreadQueries().build();
        Note note =  new Note();
        List<Note> notes = new ArrayList<>() ;
        notes = noteDB.noteDAO().getByTitle("Nothing");
        for (Note n:notes){
            noteDB.noteDAO().deleteNote(n);
        }
        note.title ="Nothing";
        noteDB.noteDAO().insertAll(note);
    }

    public NoteDB getNoteDB(){
        return noteDB;
    }
}
