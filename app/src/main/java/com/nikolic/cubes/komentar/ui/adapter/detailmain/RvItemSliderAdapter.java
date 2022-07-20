package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.databinding.ItemPageBinding;

import com.nikolic.cubes.komentar.databinding.RvItemTagoviBinding;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemsAdapterTags;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RvItemSliderAdapter extends RecyclerView.Adapter<RvItemSliderAdapter.NewsViewHolder2> {

    private ArrayList<News>list;


    public RvItemSliderAdapter(ArrayList<News> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RvItemSliderAdapter.NewsViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemPageBinding binding=ItemPageBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new RvItemSliderAdapter.NewsViewHolder2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RvItemSliderAdapter.NewsViewHolder2 holder, int position) {


        News news = list.get(position);

        holder.binding.textView.setText(news.title);
        Picasso.get().load(news.image).into(holder.binding.imageView);
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

    public class NewsViewHolder2 extends RecyclerView.ViewHolder{

        ItemPageBinding binding;

        public NewsViewHolder2(@NonNull ItemPageBinding  binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }

}
