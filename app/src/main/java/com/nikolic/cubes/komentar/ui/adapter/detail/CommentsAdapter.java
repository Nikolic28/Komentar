package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.Comment;
import com.nikolic.cubes.komentar.data.model.responsecomment.CommentResponseModel;
import com.nikolic.cubes.komentar.databinding.RvItemCommentBinding;
import com.nikolic.cubes.komentar.databinding.RvItemTagoviBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    public ArrayList<Comment> list;

    public CommentsAdapter(ArrayList<Comment> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CommentsAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvItemCommentBinding binding=RvItemCommentBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new CommentsAdapter.CommentViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.CommentViewHolder holder, int position) {

        Comment comment = list.get(position);

        holder.binding.textViewName.setText(comment.name);
        holder.binding.textViewDescription.setText(comment.content);
        holder.binding.textViewDate.setText(comment.created_at.substring(0,19));
        holder.binding.textViewCountDis.setText(""+comment.negative_votes);
        holder.binding.textViewLikeCount.setText(""+comment.positive_votes);


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);


        holder.binding.imageViewLike.setOnClickListener(new View.OnClickListener() {
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

        holder.binding.imageViewDislike.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class CommentViewHolder extends RecyclerView.ViewHolder{

        RvItemCommentBinding binding;

        public CommentViewHolder(@NonNull RvItemCommentBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }

}
