package com.pop.practic.repository.room;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Goals {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "startDate")
    public String startDate;
    @ColumnInfo(name = "endDate")
    public String endDate;
}