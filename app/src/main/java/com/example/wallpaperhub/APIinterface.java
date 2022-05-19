package com.example.wallpaperhub;






import static com.example.wallpaperhub.APIUtilities.API_KEY;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIinterface {
    String BASE_URL="https://api.pexels.com/v1/";


    //this is for latest image
    @Headers("Authorization: "+API_KEY)
    @GET("curated")
    Call<SearchModel> getImage(
            @Query("page") int page,
            @Query("per_page") int per_page
    );



    //this is for search
    @Headers("Authorization: "+API_KEY)
    @GET("search")
    Call<SearchModel> getSearchImage(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int per_page
    );

}
