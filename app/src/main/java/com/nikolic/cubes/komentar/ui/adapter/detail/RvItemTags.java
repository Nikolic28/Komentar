package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.nikolic.cubes.komentar.data.model.Tags;
import com.nikolic.cubes.komentar.databinding.RvItemDetailTagsBinding;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

import java.util.ArrayList;

public class RvItemTags implements RvItemDetail{

    public ArrayList<Tags>tags;

    public RvItemTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemDetailTagsBinding binding= (RvItemDetailTagsBinding) holder.binding;

        binding.recyclerView.setLayoutManager(new GridLayoutManager(holder.itemView.getContext(),3));
        binding.recyclerView.setAdapter(new RvItemsAdapterTags(tags, holder.itemView.getContext()));


    }
}
