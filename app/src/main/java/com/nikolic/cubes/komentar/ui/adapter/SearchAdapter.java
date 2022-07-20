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
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsBinding;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {


    private Context context;
    public ArrayList<News> list;


    public SearchAdapter(Context context, ArrayList<News> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RvItemSmallNewsBinding binding =RvItemSmallNewsBinding.inflate(LayoutInflater.from(context),parent,false);


        return  new SearchViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {



        News news = list.get(position);

        holder.binding.textViewTitle.setText(news.title);
        holder.binding.textViewDate.setText(news.created_at.substring(10,16));
        holder.binding.textViewCategory.setText(news.category.name);
        holder.binding.textViewCategory.setTextColor((Color.parseColor(news.category.color)));
        Picasso.get().load(news.image).into(holder.binding.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("id",news.id);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void refreshNewsList(ArrayList<News> newList){
        this.list = newList;
        notifyDataSetChanged();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{

        private RvItemSmallNewsBinding binding;

        public SearchViewHolder(RvItemSmallNewsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
