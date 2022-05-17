package com.pop.practic.repository.room.notes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert
    void insertAll(Note... note);

    @Delete
    void deleteNote(Note note);

    @Query("SELECT * FROM note")
    List<Note> getAll();

    @Update
    public void updateUsers(Note... notes);
}
