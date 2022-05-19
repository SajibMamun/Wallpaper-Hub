package com.example.wallpaperhub;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUtilities {

    private static  Retrofit retrofit=null;
    public  static final String API_KEY="563492ad6f91700001000001882248a8d5f7464b9989e04eeded709d";


    public static APIinterface getaApiInterface(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(APIinterface.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(APIinterface.class);
    }
}
