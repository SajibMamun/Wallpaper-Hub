package com.example.wallpaperhub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.BitSet;

public class FullScreenActivity extends AppCompatActivity {
    Intent intent;
    ImageView fimageView;
    Button  setbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final WallpaperManager wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
        setbutton=findViewById(R.id.setWallpaperButtonid);
        fimageView=findViewById(R.id.FullScreenImageID);

        intent=getIntent();
        String url=intent.getStringExtra("image");

        Glide.with(getApplicationContext()).load(url).into(fimageView);


        setbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Bitmap bitmap=((BitmapDrawable) fimageView.getDrawable())
                            .getBitmap();
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(getApplicationContext(),"Set Succesfully",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        });
    }
}