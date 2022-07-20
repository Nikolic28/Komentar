package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.databinding.RvItemVideoBinding;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;
import com.squareup.picasso.Picasso;

public class RvItemVideoMain implements RvItemDetailMain{


    private News news;

    public RvItemVideoMain(News news) {
        this.news = news;
    }

    @Override
    public int getType() {
        return 7;
    }

    @Override
    public void bind(MainAdapter.MainViewHolder holder) {

        RvItemVideoBinding binding = (RvItemVideoBinding) holder.binding;

        binding.textViewTitle.setText(news.title);
        binding.textViewDate.setText(news.created_at.substring(10,16));
       binding.textViewCategory.setText(news.category.name);
       binding.textViewCategory.setTextColor((Color.parseColor(news.category.color)));
        Picasso.get().load(news.image).into(binding.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.url));
                holder.itemView.getContext().startActivity(browserIntent);
            }
        });

    }
}
