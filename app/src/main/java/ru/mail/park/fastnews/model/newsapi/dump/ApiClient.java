package ru.mail.park.fastnews.model.newsapi.dump;

import android.support.annotation.NonNull;

import java.net.URI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static ApiClient apiClient;
    private static Retrofit retrofit;
    private final URI GsonConverterFactory;

    private ApiClient(){
        ApiClient.retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){
        if (ApiClient.apiClient == null){
            ApiClient.apiClient = new ApiClient();
        }
        return ApiClient.apiClient;
    }


    @NonNull
    public ApiInterface getApi(){
        return ApiClient.retrofit.create(ApiInterface.class);
    }
}
