package com.pop.practic.repository.room.todolist;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pop.practic.repository.room.todolist.ToDoRef;
import com.pop.practic.repository.room.todolist.ToDoRefDAO;

@Database(entities = {ToDoRef.class}, version = 1)
public abstract class ToDoRefDB extends RoomDatabase {
    public abstract ToDoRefDAO todorefDAO();
}