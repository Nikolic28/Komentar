package com.nikolic.cubes.komentar.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemVideoBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private Context context;
    public ArrayList<News> list;

    public VideoAdapter(Context context, ArrayList<News> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RvItemVideoBinding binding =RvItemVideoBinding.inflate(LayoutInflater.from(context),parent,false);


        return  new VideoAdapter.VideoViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        News news = list.get(position);

        holder.binding.textViewTitle.setText(news.title);
        holder.binding.textViewDate.setText(news.created_at.substring(10,16));
        holder.binding.textViewCategory.setText(news.category.name);
        holder.binding.textViewCategory.setTextColor((Color.parseColor(news.category.color)));
        Picasso.get().load(news.image).into(holder.binding.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.url));
                holder.itemView.getContext().startActivity(browserIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        private RvItemVideoBinding binding;

        public VideoViewHolder(RvItemVideoBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
