package com.nikolic.cubes.komentar.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.databinding.RvItemBigNewsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsBinding;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    private Context context;
    public ArrayList<News> list;


    public NewsAdapter(Context context, ArrayList<News> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType== 0){

            RvItemBigNewsBinding binding =RvItemBigNewsBinding.inflate(LayoutInflater.from(context),parent,false);

            return  new NewsViewHolder(binding);

        }
        else {

            RvItemSmallNewsBinding binding =RvItemSmallNewsBinding.inflate(LayoutInflater.from(context),parent,false);

            return  new NewsViewHolder(binding);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {



        News news = list.get(position);

        if (position== 0){
            holder.bindingBig.textViewTitle.setText(news.title);
            holder.bindingBig.textViewDate.setText(news.created_at.substring(10,16));
            holder.bindingBig.textViewCategory.setText(news.category.name);
            holder.bindingBig.textViewCategory.setTextColor((Color.parseColor(news.category.color)));
            Picasso.get().load(news.image).into(holder.bindingBig.imageView);

        }
        else {
            holder.bindingSmall.textViewTitle.setText(news.title);
            holder.bindingSmall.textViewDate.setText(news.created_at.substring(10,16));
            holder.bindingSmall.textViewCategory.setText(news.category.name);
            holder.bindingSmall.textViewCategory.setTextColor((Color.parseColor(news.category.color)));
            Picasso.get().load(news.image).into(holder.bindingSmall.imageView);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("id",news.id);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {


        return  position;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        private RvItemSmallNewsBinding bindingSmall;
        private RvItemBigNewsBinding bindingBig;

        public NewsViewHolder(RvItemSmallNewsBinding bindingSmall) {
            super(bindingSmall.getRoot());
            this.bindingSmall = bindingSmall;
        }
        public NewsViewHolder(RvItemBigNewsBinding bindingBig) {
            super(bindingBig.getRoot());
            this.bindingBig = bindingBig;
        }

    }

}
