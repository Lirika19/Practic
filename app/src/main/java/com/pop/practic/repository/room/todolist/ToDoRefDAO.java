package com.pop.practic.repository.room.todolist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pop.practic.repository.room.todolist.ToDoRef;

import java.util.List;

@Dao
public interface ToDoRefDAO {
    @Insert
    void insertAll(ToDoRef... todoref);

    @Delete
    void deleteNote(ToDoRef todoref);

    @Query("SELECT * FROM todoref")
    List<ToDoRef> getAll();

    @Query("SELECT * FROM todoref WHERE title IN(:title)")
    List<ToDoRef> getByTitle(String title);

    @Update
    public void updateUsers(ToDoRef... todorefs);

}
