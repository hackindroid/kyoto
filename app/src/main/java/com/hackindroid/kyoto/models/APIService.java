package com.hackindroid.kyoto.models;

import com.hackindroid.kyoto.api.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sushila on 12/15/2017.
 */

public class APIService {
    public static API api= null;
    public static API getApi(){
        if (api==null){
            Retrofit retrofit= new Retrofit.Builder().baseUrl("gs://kyoto-e42c4.appspot.com")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            api= retrofit.create(API.class);
        }
        return api;
    }
}
