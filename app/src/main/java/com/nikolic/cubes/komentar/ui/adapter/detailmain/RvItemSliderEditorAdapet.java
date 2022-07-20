package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.databinding.ItemPageBinding;
import com.nikolic.cubes.komentar.databinding.RvItemEdoterSliderBinding;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RvItemSliderEditorAdapet extends RecyclerView.Adapter<RvItemSliderEditorAdapet.NewsViewHolder3> {

    private ArrayList<News> list;

    public RvItemSliderEditorAdapet(ArrayList<News> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RvItemSliderEditorAdapet.NewsViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RvItemEdoterSliderBinding binding= RvItemEdoterSliderBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new RvItemSliderEditorAdapet.NewsViewHolder3(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RvItemSliderEditorAdapet.NewsViewHolder3 holder, int position) {


        News news = list.get(position);

        holder.binding.textView2.setText(news.title);
        Picasso.get().load(news.image).into(holder.binding.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), NewsDetailActivity.class);
                intent.putExtra("id",news.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.binding.textViewDate.setText(news.created_at.substring(10,16));
        holder.binding.textViewCategory.setText(news.category.name);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewsViewHolder3 extends RecyclerView.ViewHolder{

        RvItemEdoterSliderBinding binding;

        public NewsViewHolder3(@NonNull  RvItemEdoterSliderBinding  binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }

}
