package com.nikolic.cubes.komentar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.response.ResponseModel;
import com.nikolic.cubes.komentar.databinding.ActivityHomeBinding;
import com.nikolic.cubes.komentar.databinding.ActivityTagBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.NewsAdapter;
import com.nikolic.cubes.komentar.ui.adapter.SearchAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TagActivity extends AppCompatActivity {

    private ActivityTagBinding binding;
    public  int tag;
    public  String title;
    public ArrayList<News>news ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityTagBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        tag=getIntent().getExtras().getInt("id");
        title=getIntent().getExtras().getString("title");



        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);


        binding.textViewTitle.setText(title);

    service.getTags(tag).enqueue(new Callback<ResponseModel>() {
        @Override
        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
            news = response.body().data.news;


            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            binding.recyclerView.setAdapter(new SearchAdapter(getApplicationContext(),news));

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