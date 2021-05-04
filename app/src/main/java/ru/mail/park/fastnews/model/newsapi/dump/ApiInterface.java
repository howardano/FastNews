package ru.mail.park.fastnews.model.newsapi.dump;

import android.support.annotation.NonNull;
import android.telecom.Call;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @NonNull
    @GET("top-headlines")
    Call<Headline> getHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey);

    @GET("everything")
    Call<Headline> getSpecificData(
            @Query("q") String query,
            @Query("apiKey") String apiKey);



}
