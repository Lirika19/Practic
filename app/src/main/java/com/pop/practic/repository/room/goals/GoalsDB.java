package com.pop.practic.repository.room.goals;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDAO;

@Database(entities = {Goals.class}, version = 1)
public abstract class GoalsDB extends RoomDatabase{
    public abstract GoalsDAO goalsDAO();
}
