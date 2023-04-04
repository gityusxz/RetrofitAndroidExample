package com.example.retrofitandroidexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitandroidexample.adapter.CountryAdapter;
import com.example.retrofitandroidexample.model.Country;
import com.example.retrofitandroidexample.retrofit.GetDataServices;
import com.example.retrofitandroidexample.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //membuat loading
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        //membuat koneksi api
        GetDataServices services = RetrofitClientInstance.getRetrofit().create(GetDataServices.class);
        Call<List<Country>> call = services.getCountries();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "" + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("error", t.toString());
            }
        });
    }

    private void generateDataList(List<Country> body){
        recyclerView = findViewById(R.id.custom_rec_view);
        adapter = new CountryAdapter(body, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}