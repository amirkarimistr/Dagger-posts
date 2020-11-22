package com.example.myapplicationjava.main_activity_feature;

import com.example.myapplicationjava.MainActivity;
import com.example.myapplicationjava.adapter.RandomUserAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public RandomUserAdapter getRandomUserAdapter(){
        return new RandomUserAdapter(mainActivity);
    }
}
