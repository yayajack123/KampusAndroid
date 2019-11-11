package com.example.kampusku.Kampus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.kampusku.ApiHelper.ApiClient;
import com.example.kampusku.ApiHelper.BaseApiHelper;
import com.example.kampusku.ApiHelper.RetrofitClient;
import com.example.kampusku.ApiHelper.UtilsApi;
import com.example.kampusku.MainActivity;
import com.example.kampusku.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KampusList extends AppCompatActivity {
    public static final String URL = "http://10.0.2.2:8000/api/";
    private List<ResultKampus> results = new ArrayList<>();
    private KampusRecyclerViewAdapter viewAdapter;
    BaseApiHelper mApiService;

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listuniv);
        recyclerView = (RecyclerView)findViewById(R.id.rv_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kampus");
        mApiService = UtilsApi.getAPIService();
        viewAdapter = new KampusRecyclerViewAdapter(this, results);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
        Log.e("m", "anjing");
        loadDataKategori();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadDataKategori() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BaseApiHelper api = retrofit.create(BaseApiHelper.class);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        Call<GetKampus> call = api.getKampus();
        Log.e("PROGRESSSS", "SUDAH SAMPAI SINI");
        call.enqueue(new Callback<GetKampus>() {
            @Override
            public void onResponse(Call<GetKampus> call, Response<GetKampus> response) {
                Log.e("PROGRESSSS", "SUDAH SAMPAI SINI2");
                progressBar.setVisibility(View.GONE);
                String value = response.body().getStatus();
                results = response.body().getResult();
                Log.e("ERROR", "asa" + results.size());
                viewAdapter = new KampusRecyclerViewAdapter(KampusList.this, results);
                recyclerView.setAdapter(viewAdapter);

            }

            @Override
            public void onFailure(Call<GetKampus> call, Throwable t) {

            }
        });
    }

    public void refresh() {
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        Call<GetKampus> kampusCall = mApiService.getKampus();
        kampusCall.enqueue(new Callback<GetKampus>() {
            @Override
            public void onResponse(Call<GetKampus> call, Response<GetKampus>
                    response) {
                List<ResultKampus> kampusList = response.body().getResult();
                progressBar.setVisibility(View.GONE);
                String value = response.body().getStatus();
                Log.d("Retrofit Get", "value: " +
                        kampusList.toString());
                Log.d("Retrofit Get", "Jumlah data Kampus: " +
                        kampusList.size());
                viewAdapter = new KampusRecyclerViewAdapter(KampusList.this,kampusList);
                recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<GetKampus> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

}
