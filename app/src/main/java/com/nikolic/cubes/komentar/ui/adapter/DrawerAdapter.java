package com.nikolic.cubes.komentar.ui.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.Category2;
import com.nikolic.cubes.komentar.databinding.RvItemBigNewsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemCategoryDrawerBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsBinding;
import com.nikolic.cubes.komentar.ui.activity.CategoryActivity;
import com.nikolic.cubes.komentar.ui.activity.HomeMainActivity;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;

import java.util.ArrayList;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {

    public ArrayList<Category2> categoryList;

    public DrawerAdapter(ArrayList<Category2> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public DrawerAdapter.DrawerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RvItemCategoryDrawerBinding binding =RvItemCategoryDrawerBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return  new DrawerAdapter.DrawerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerAdapter.DrawerViewHolder holder, int position) {

        if (position==0){

            holder.binding.textView.setText("Naslovna");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.itemView.getContext(), HomeMainActivity.class);
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        }
        else {

            Category2 category = categoryList.get(position);

            holder.binding.textView.setText(category.name);
            holder.binding.viewColor.setBackgroundColor(Color.parseColor(category.color));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.itemView.getContext(), CategoryActivity.class);
                    intent.putExtra("id", category.id);
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class DrawerViewHolder extends RecyclerView.ViewHolder {

        private RvItemCategoryDrawerBinding binding;


        public DrawerViewHolder(RvItemCategoryDrawerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
