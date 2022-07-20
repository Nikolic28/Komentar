package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsBinding;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;
import com.squareup.picasso.Picasso;

public class RvItemNewsRelated implements RvItemDetail{


    public News news;

    public RvItemNewsRelated(News news) {
        this.news = news;
    }

    @Override
    public int getType() {
        return 9;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {


        RvItemSmallNewsBinding binding= (RvItemSmallNewsBinding) holder.binding;

       binding.textViewTitle.setText(news.title);
       binding.textViewDate.setText(news.created_at.substring(10,16));
        binding.textViewCategory.setText(news.category.name);
       binding.textViewCategory.setTextColor((Color.parseColor(news.category.color)));
        Picasso.get().load(news.image).into(binding.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), NewsDetailActivity.class);
                intent.putExtra("id",news.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }
}
