package com.nikolic.cubes.komentar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.data.model.Comment;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.responsecomment.CommentResponseModel;
import com.nikolic.cubes.komentar.data.model.responsenewsdetail.DataResponseDetailModel;
import com.nikolic.cubes.komentar.data.model.responsenewsdetail.ResponseDetailModel;
import com.nikolic.cubes.komentar.databinding.ActivityHomeBinding;
import com.nikolic.cubes.komentar.databinding.ActivityNewsDetailBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;
import com.nikolic.cubes.komentar.ui.adapter.VideoAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsDetailActivity extends AppCompatActivity {

    private ActivityNewsDetailBinding binding;
    private DataResponseDetailModel data;
    private int id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityNewsDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        id= getIntent().getExtras().getInt("id");




        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);


        service.getNewsDetail(id).enqueue(new Callback<ResponseDetailModel>() {
            @Override
            public void onResponse(Call<ResponseDetailModel> call, Response<ResponseDetailModel> response) {

                data= response.body().data;

                service.getComments(id).enqueue(new Callback<CommentResponseModel>() {
                    @Override
                    public void onResponse(Call<CommentResponseModel> call, Response<CommentResponseModel> response) {
                       DataContainer.commentList= response.body().data;

                        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        binding.recyclerView.setAdapter(new NewsDetailAdapter(getApplicationContext(),data, DataContainer.commentList ));

                    }

                    @Override
                    public void onFailure(Call<CommentResponseModel> call, Throwable t) {

                    }
                });









            }

            @Override
            public void onFailure(Call<ResponseDetailModel> call, Throwable t) {

            }
        });

        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.imageViewComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AllCommentsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               getApplicationContext().startActivity(intent);
            }
        });

        binding.imageViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,data.url);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });





    }
}