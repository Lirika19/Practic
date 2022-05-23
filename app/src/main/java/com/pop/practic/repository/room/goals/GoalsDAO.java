package com.pop.practic.repository.room.goals;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pop.practic.repository.room.notes.Note;

import java.util.List;

public interface GoalsDAO {
    @Insert
    void insertAll(Goals... goals);
    
    @Query("SELECT * FROM goals")
    List<Goals> getAll();

    @Query("SELECT * FROM goals WHERE title IN(:title) ")
    List<Goals> getByTitle(String title);

    @Query("SELECT * FROM goals WHERE startDate IN(:startDate) ")
    List<Goals> getBystartDate(String startDate);

    @Query("SELECT * FROM goals WHERE endDate IN(:endDate) ")
    List<Goals> getByendDate(String endDate);


    @Delete
    void deleteNote(Goals goals);

    @Update
    public void updateUsers(Goals... goals);
}
