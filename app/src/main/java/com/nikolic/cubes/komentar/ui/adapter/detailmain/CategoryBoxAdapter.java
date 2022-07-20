package com.nikolic.cubes.komentar.ui.adapter.detailmain;

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
import com.nikolic.cubes.komentar.ui.adapter.NewsAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryBoxAdapter extends RecyclerView.Adapter<CategoryBoxAdapter.CategoryBoxViewHolder> {


    private Context context;
    public ArrayList<News> list;


    public CategoryBoxAdapter(Context context, ArrayList<News> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryBoxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType== 0){

            RvItemBigNewsBinding binding =RvItemBigNewsBinding.inflate(LayoutInflater.from(context),parent,false);

            return  new CategoryBoxAdapter.CategoryBoxViewHolder(binding);

        }
        else {

            RvItemSmallNewsBinding binding =RvItemSmallNewsBinding.inflate(LayoutInflater.from(context),parent,false);

            return  new CategoryBoxAdapter.CategoryBoxViewHolder(binding);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryBoxViewHolder holder, int position) {



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
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return 5;
    }


    @Override
    public int getItemViewType(int position) {


        return  position;
    }

    public class CategoryBoxViewHolder extends RecyclerView.ViewHolder{

        private RvItemSmallNewsBinding bindingSmall;
        private RvItemBigNewsBinding bindingBig;

        public CategoryBoxViewHolder(RvItemSmallNewsBinding bindingSmall) {
            super(bindingSmall.getRoot());
            this.bindingSmall = bindingSmall;
        }
        public CategoryBoxViewHolder(RvItemBigNewsBinding bindingBig) {
            super(bindingBig.getRoot());
            this.bindingBig = bindingBig;
        }

    }
}
