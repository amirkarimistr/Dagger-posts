package com.example.myapplicationjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.myapplicationjava.adapter.RandomUserAdapter;
import com.example.myapplicationjava.api.RandomUserApi;
import com.example.myapplicationjava.app.RandomUserApplication;
import com.example.myapplicationjava.databinding.ActivityMainBinding;
import com.example.myapplicationjava.main_activity_feature.DaggerMainActivityComponent;
import com.example.myapplicationjava.main_activity_feature.MainActivityComponent;
import com.example.myapplicationjava.main_activity_feature.MainActivityModule;
import com.example.myapplicationjava.models.Photo;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Inject
    RandomUserApi api;

    @Inject
    RandomUserAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .photoComponent(RandomUserApplication.get(this).getPhotoComponent())
                .build();

        mainActivityComponent.injectMainActivity(this);

        mBinding.rv.setAdapter(adapter);
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));

        api.getPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()){
                    adapter.setItems(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}