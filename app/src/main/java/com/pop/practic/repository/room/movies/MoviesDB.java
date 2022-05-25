package com.pop.practic.repository.room.movies;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.notes.NoteDAO;

@Database(entities = {Movies.class}, version = 2)
public abstract class MoviesDB extends RoomDatabase {
    public abstract MoviesDAO moviesDAO();
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Employee ADD COLUMN birthday INTEGER DEFAULT 0 NOT NULL");
        }

    };
}
