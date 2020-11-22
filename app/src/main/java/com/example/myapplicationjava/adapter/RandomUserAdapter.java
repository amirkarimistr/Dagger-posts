package com.example.myapplicationjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationjava.MainActivity;
import com.example.myapplicationjava.models.Photo;
import com.example.myapplicationjava.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hari on 20/11/17.
 */

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder> {


    private final MainActivity mainActivity;
    private List<Photo> photoList = new ArrayList<>();


    public RandomUserAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        Photo photo = photoList.get(position);
        holder.textView.setText(photo.getName());

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public void setItems(List<Photo> results) {
        photoList = results;
        notifyDataSetChanged();
    }

    public class RandomUserViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public RandomUserViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textView);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }
}