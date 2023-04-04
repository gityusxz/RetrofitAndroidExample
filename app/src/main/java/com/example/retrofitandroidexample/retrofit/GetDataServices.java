package com.example.retrofitandroidexample.retrofit;

import com.example.retrofitandroidexample.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataServices {

    @GET("/country.json")
    public Call<List<Country>> getCountries();
}
