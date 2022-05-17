package com.pop.practic.repository.room.notes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "title")
    public String title;
}
