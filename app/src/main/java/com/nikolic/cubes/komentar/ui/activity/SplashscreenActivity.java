package com.nikolic.cubes.komentar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.data.model.response.ResponseModel;
import com.nikolic.cubes.komentar.data.model.responsecategory.ResponseCategory;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageResponseModel;
import com.nikolic.cubes.komentar.databinding.ActivitySplashscreenBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashscreenActivity extends AppCompatActivity {


    private ActivitySplashscreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivitySplashscreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        service.getCategory().enqueue(new Callback<ResponseCategory>() {
            @Override
            public void onResponse(Call<ResponseCategory> call, Response<ResponseCategory> response) {
                DataContainer.categoryList=response.body().data;


            }

            @Override
            public void onFailure(Call<ResponseCategory> call, Throwable t) {

            }
        });

        service.getLatestNews().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                DataContainer.latestNews=response.body().data.news;
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });



        service.getHomePage().enqueue(new Callback<HomePageResponseModel>() {
            @Override
            public void onResponse(Call<HomePageResponseModel> call, Response<HomePageResponseModel> response) {
                DataContainer.data=response.body().data;

                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                finish();

            }

            @Override
            public void onFailure(Call<HomePageResponseModel> call, Throwable t) {

            }
        });




    }
}