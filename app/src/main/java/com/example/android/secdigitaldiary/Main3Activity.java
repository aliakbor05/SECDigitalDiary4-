package com.example.android.secdigitaldiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.secdigitaldiary.teachersInfo.ApiClient;
import com.example.android.secdigitaldiary.teachersInfo.ApiInterface;
import com.example.android.secdigitaldiary.teachersInfo.Info;
import com.example.android.secdigitaldiary.teachersInfo.RecyclerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Info>infos;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        ///adapter  = new RecyclerAdapter(info);
        ///recyclerView.setAdapter(adapter);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Info>> call = apiInterface.getInfo();

        call.enqueue(new Callback<List<Info>>() {
            @Override
            public void onResponse(Call<List<Info>> call, Response<List<Info>> response) {

                infos = response.body();
                adapter  = new RecyclerAdapter(infos);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Info>> call, Throwable t) {
                Toast.makeText(Main3Activity.this,"Failure!"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
