package com.pop.practic.repository;

import android.content.Context;

import androidx.room.Room;

import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDB;

public class Repository {
    private Context context;
    private NoteDB noteDB;
    public Repository(Context context){
        this.context = context;
        noteDB = Room.databaseBuilder(context,NoteDB.class, "database-name").allowMainThreadQueries().build();
        Note note = new Note();
        note.title="DONUTS";
        noteDB.noteDAO().insertAll(note);
    }

    public NoteDB getNoteDB(){
        return noteDB;
    }
}
