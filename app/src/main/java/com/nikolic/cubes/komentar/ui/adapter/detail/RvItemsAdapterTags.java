package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.Tags;
import com.nikolic.cubes.komentar.databinding.RvItemTagoviBinding;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;
import com.nikolic.cubes.komentar.ui.activity.TagActivity;

import java.util.ArrayList;

public class RvItemsAdapterTags extends RecyclerView.Adapter<RvItemsAdapterTags.TagViewHolder> {


    private ArrayList<Tags>list;
    private Context context;


    public RvItemsAdapterTags(ArrayList<Tags> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RvItemsAdapterTags.TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RvItemTagoviBinding binding=RvItemTagoviBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new TagViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RvItemsAdapterTags.TagViewHolder holder, int position) {

        Tags tags = list.get(position);

        holder.binding.button.setText(tags.title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TagActivity.class);
                intent.putExtra("tag",tags.id);
                intent.putExtra("title",tags.title);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TagViewHolder extends RecyclerView.ViewHolder{

        RvItemTagoviBinding binding;

        public TagViewHolder(@NonNull RvItemTagoviBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }

}
