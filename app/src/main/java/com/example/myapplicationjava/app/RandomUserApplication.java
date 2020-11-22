package com.example.myapplicationjava.app;

import android.app.Activity;
import android.app.Application;

import com.example.myapplicationjava.DaggerPhotoComponent;
import com.example.myapplicationjava.PhotoComponent;
import com.example.myapplicationjava.modules.ContextModule;
import com.example.myapplicationjava.modules.RandomUserModule;

import timber.log.Timber;

public class RandomUserApplication extends Application {

    private PhotoComponent photoComponent;

    public static RandomUserApplication get(Activity activity){
        return (RandomUserApplication)activity.getApplication();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        photoComponent = DaggerPhotoComponent.builder()
                .randomUserModule(new RandomUserModule())
                .contextModule(new ContextModule(this))
                .build();

    }

    public PhotoComponent getPhotoComponent(){
        return photoComponent;
    }
}
