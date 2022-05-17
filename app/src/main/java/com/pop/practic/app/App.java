package com.pop.practic.app;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.pop.practic.repository.Repository;

public class App extends Application {
    public static App instance;
    private Repository repository;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        repository = new Repository(getApplicationContext());
    }


    public static App getInstance() {
        return instance;
    }

    public Repository getRepository() {
        return repository;
    }
}
