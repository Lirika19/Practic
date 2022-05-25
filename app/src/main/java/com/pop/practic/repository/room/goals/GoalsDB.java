package com.pop.practic.repository.room.goals;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Goals.class}, version = 2)
public abstract class GoalsDB extends RoomDatabase{
    public abstract GoalsDAO goalsDAO();
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
       }
    };
}
