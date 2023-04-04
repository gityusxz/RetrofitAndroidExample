package com.example.retrofitandroidexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitandroidexample.R;
import com.example.retrofitandroidexample.model.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CustomViewHolder> {
    private List<Country> dataCountry;
    private Context context;

public CountryAdapter(List<Country> dataCountry, Context context){
    this.dataCountry = dataCountry;
    this.context = context;
}
    //membuat tampilan awal (create from parent)
    @NonNull
    @Override
    public CountryAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_item, parent, false);
        return new CustomViewHolder(view);

    }
    //mengakses komponen layout
    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CustomViewHolder holder, int position) {
        holder.txtId.setText(String.valueOf(dataCountry.get(position).getId()));
        holder.txtNamaCountry.setText(dataCountry.get(position).getNamaCountry());

    }
    //mendapatkan panjang array / list
    @Override
    public int getItemCount() {

    return dataCountry.size();
    }
    //melakukan proses binding terhadap komponen layout
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View nView;

        TextView txtId, txtNamaCountry;

        CustomViewHolder(View itemView){
           super(itemView);
           nView = itemView;

           txtId = nView.findViewById(R.id.txt_id);
           txtNamaCountry = nView.findViewById(R.id.txt_country);
        }


    }
}
