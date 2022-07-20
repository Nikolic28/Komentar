package com.nikolic.cubes.komentar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.response.ResponseModel;
import com.nikolic.cubes.komentar.databinding.ActivityAllCommentsBinding;
import com.nikolic.cubes.komentar.databinding.ActivityCategoryBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.NewsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryActivity extends AppCompatActivity {

    ActivityCategoryBinding binding;
    public int id;
    public ArrayList<News>newsList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityCategoryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        id= getIntent().getExtras().getInt("id");


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        service.getCategoryNews(id).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                newsList=response.body().data.news;

                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                binding.recyclerView.setAdapter(new NewsAdapter(getApplicationContext(),newsList));

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}