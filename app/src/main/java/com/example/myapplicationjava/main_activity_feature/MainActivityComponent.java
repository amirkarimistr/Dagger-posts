package com.example.myapplicationjava.main_activity_feature;

import com.example.myapplicationjava.MainActivity;
import com.example.myapplicationjava.PhotoComponent;

import dagger.Component;

@Component(dependencies = {PhotoComponent.class}, modules = {MainActivityModule.class})
@MainActivityScope
public interface MainActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}
