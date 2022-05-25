package com.pop.practic.repository.room.goals;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface GoalsDAO {
    @Insert
    void insertAll(Goals... goals);
    
    @Query("SELECT * FROM Goals")
    List<Goals> getAll();

    @Query("SELECT * FROM Goals WHERE title IN(:title) ")
    List<Goals> getByTitle(String title);

    @Delete
    void deleteNote(Goals goals);

    @Update
    public void updateUsers(Goals... goals);
}
