package com.pop.practic.repository.room.movies;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Movies {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "title")
    public String title;
}
