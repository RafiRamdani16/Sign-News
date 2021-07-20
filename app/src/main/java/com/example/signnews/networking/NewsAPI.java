package com.example.signnews.networking;

import com.example.signnews.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {
    @GET("top-headlines")
    Call<NewsResponse> getHeadlineNews(@Query("country") String newCountry, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<NewsResponse> getNewsEverything(@Query("qInTitle") String katakunci, @Query("apiKey") String apiKey);

}
