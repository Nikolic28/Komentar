package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.databinding.ItemPageBinding;
import com.nikolic.cubes.komentar.databinding.RvItemMostBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsMainBinding;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;

import java.util.ArrayList;

public class RvItemSmallNewsAdapter extends RecyclerView.Adapter<RvItemSmallNewsAdapter.SmallNewsViewHolder>{

    private ArrayList<News> list;

    public RvItemSmallNewsAdapter(ArrayList<News> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RvItemSmallNewsAdapter.SmallNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvItemSmallNewsMainBinding binding=RvItemSmallNewsMainBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new RvItemSmallNewsAdapter.SmallNewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RvItemSmallNewsAdapter.SmallNewsViewHolder holder, int position) {

        News news = list.get(position);

        holder.binding.textViewTime.setText(news.created_at.substring(11,16));
        holder.binding.textViewTitle.setText(news.title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), NewsDetailActivity.class);
                intent.putExtra("id",news.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SmallNewsViewHolder extends RecyclerView.ViewHolder{

        RvItemSmallNewsMainBinding binding;

        public SmallNewsViewHolder(@NonNull RvItemSmallNewsMainBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }

}
