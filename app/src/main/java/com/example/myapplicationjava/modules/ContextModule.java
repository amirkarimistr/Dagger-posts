package com.example.myapplicationjava.modules;

import android.content.Context;

import com.example.myapplicationjava.qualifier.ApplicationContext;
import com.example.myapplicationjava.scope.RandomUserApplicationScope;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    public Context context;

    public ContextModule(Context context){
        this.context = context.getApplicationContext();
    }

    @Provides
    @RandomUserApplicationScope
    @ApplicationContext
    public Context getContext(){
        return context;
    }

}
