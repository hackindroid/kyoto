package com.hackindroid.kyoto.api;



import com.hackindroid.kyoto.models.AdDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sushila on 12/15/2017.
 */

public interface API {
    @GET("/Ads/anubhav.json")
    Call<ArrayList<AdDetails>> getDetails();
}
