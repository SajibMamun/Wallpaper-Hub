package com.example.wallpaperhub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {
  Context context;
  ArrayList<ImageModel> wallpaperlist;

    public WallpaperAdapter(Context context, ArrayList<ImageModel> wallpaperlist) {
        this.context = context;
        this.wallpaperlist = wallpaperlist;
    }

    @NonNull
    @Override
    public WallpaperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context)
                .load(wallpaperlist.get(position).getSrc().getPortrait())
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,FullScreenActivity.class);
                intent.putExtra("image",wallpaperlist.get(position).getSrc().getPortrait());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallpaperlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.itemimageid);
        }
    }
}
