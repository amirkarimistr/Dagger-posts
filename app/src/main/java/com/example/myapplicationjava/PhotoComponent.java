package com.example.myapplicationjava;

import com.example.myapplicationjava.api.RandomUserApi;
import com.example.myapplicationjava.modules.RandomUserModule;
import com.example.myapplicationjava.scope.RandomUserApplicationScope;

import dagger.Component;

@Component(modules = {RandomUserModule.class})
@RandomUserApplicationScope
public interface PhotoComponent {
    RandomUserApi getRandomUserApi();

}
