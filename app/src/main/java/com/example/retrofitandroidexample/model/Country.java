package com.example.retrofitandroidexample.model;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("id")
    private  Integer id;

    @SerializedName("countryName")
    private String namaCountry;


    public Country(Integer id, String namaCountry) {
        this.id = id;
        this.namaCountry = namaCountry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaCountry() {
        return namaCountry;
    }

    public void setNamaCountry(String namaCountry) {
        this.namaCountry = namaCountry;
    }



}
