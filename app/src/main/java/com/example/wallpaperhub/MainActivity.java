package com.example.wallpaperhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;




import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageModel> imageModelArrayList;
    private RecyclerView recyclerView;
    WallpaperAdapter wallpaperAdapter;

    CardView mflower,manimal,mnature,mseabeach,mtreadnding,mcartoon;
    EditText  editText;
    ImageButton search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
               initialize();

        imageModelArrayList=new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        wallpaperAdapter=new WallpaperAdapter(getApplicationContext(),imageModelArrayList);
        recyclerView.setAdapter(wallpaperAdapter);

        findphotos();

        mnature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query="nature";
                getsearchimage(query);
            }
        });
        mflower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query="flower";
                getsearchimage(query);
            }
        });
        manimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query="animal";
                getsearchimage(query);
            }
        });
        mseabeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query="sea beach";
                getsearchimage(query);
            }
        });


         mcartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query="cartoon";
                getsearchimage(query);
            }
        });

         mtreadnding.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {

                 String query="trending";
                 getsearchimage(query);
             }
         });


         search.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String query=editText.getText().toString().toLowerCase();
                 if(query.isEmpty())
                 {
                     editText.setError("Enter Something");
                 }
                 else
                 {
                     getsearchimage(query);
                 }
             }
         });





    }

    private void getsearchimage(String query) {
        APIUtilities.getaApiInterface().getSearchImage(query,1,80).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                imageModelArrayList.clear();

                if(response.isSuccessful())
                {
                    imageModelArrayList.addAll(response.body().getPhotos());
                    wallpaperAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Check Connection",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });


    }

    private void findphotos() {
        APIUtilities.getaApiInterface().getImage(1,80).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                if(response.isSuccessful())
                {
                    imageModelArrayList.addAll(response.body().getPhotos());
                    wallpaperAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Check Connection",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });

    }

    private void initialize() {
        recyclerView=findViewById(R.id.recyclerviewid);
        editText=findViewById(R.id.edittextsearchID);
        search=findViewById(R.id.SearchButtonid);
        mnature=findViewById(R.id.naturebutton);
        mflower=findViewById(R.id.flowerbutton);
        manimal=findViewById(R.id.animalbutton);
        mseabeach=findViewById(R.id.seabutton);
        mtreadnding=findViewById(R.id.TrendingButton);
        mcartoon=findViewById(R.id.Cartoonbutton);
    }
}