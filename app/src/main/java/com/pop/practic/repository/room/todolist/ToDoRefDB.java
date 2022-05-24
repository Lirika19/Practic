package com.pop.practic.repository.room.todolist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ToDoRef.class}, version = 2)
public abstract class ToDoRefDB extends RoomDatabase {
    public abstract ToDoRefDAO todorefDAO();
}