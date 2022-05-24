package com.pop.practic.repository.room.todolist;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ToDoRef {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "title")
    public String title;
}


