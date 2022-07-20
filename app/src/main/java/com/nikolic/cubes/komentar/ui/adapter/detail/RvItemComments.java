package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.nikolic.cubes.komentar.data.model.Comment;
import com.nikolic.cubes.komentar.data.model.responsecomment.CommentResponseModel;
import com.nikolic.cubes.komentar.databinding.RvItemCommentBinding;
import com.nikolic.cubes.komentar.databinding.RvItemRecyclerviewCommentsBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RvItemComments implements RvItemDetail{


    public Comment comment;

    public RvItemComments(Comment comment) {
        this.comment = comment;
    }

    @Override
    public int getType() {
        return 6;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemCommentBinding binding= (RvItemCommentBinding) holder.binding;

       binding.textViewName.setText(comment.name);
        binding.textViewDescription.setText(comment.content);
       binding.textViewDate.setText(comment.created_at.substring(0,19));
        binding.textViewCountDis.setText(""+comment.negative_votes);
        binding.textViewLikeCount.setText(""+comment.positive_votes);



        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);


        binding.imageViewLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.like(Integer.parseInt(comment.id),true).enqueue(new Callback<CommentResponseModel>() {
                    @Override
                    public void onResponse(Call<CommentResponseModel> call, Response<CommentResponseModel> response) {
                        Toast.makeText(view.getContext().getApplicationContext(),"Lajkovali ste",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CommentResponseModel> call, Throwable t) {

                    }
                });
            }
        });

        binding.imageViewDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.dislike(Integer.parseInt(comment.id),true).enqueue(new Callback<CommentResponseModel>() {
                    @Override
                    public void onResponse(Call<CommentResponseModel> call, Response<CommentResponseModel> response) {
                        Toast.makeText(view.getContext().getApplicationContext(),"Dislajkovali ste",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CommentResponseModel> call, Throwable t) {

                    }
                });
            }
        });



    }
}
