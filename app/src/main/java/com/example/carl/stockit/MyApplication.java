package com.example.carl.stockit;

import android.app.Application;

import com.example.carl.stockit.Persistance.SQLiteStorageServiceImpl;
import com.example.carl.stockit.Persistance.StorageService;

/**
 * Created by carl on 27/03/16.
 */
public class MyApplication extends Application {
    private StorageService storageService;

    @Override
    public void onCreate() {
        super.onCreate();
        storageService = new SQLiteStorageServiceImpl(this);
    }

    public StorageService getStorageService() {
        return storageService;
    }
}

