package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.graphics.Color;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.responsehome.CategoryBoxResponseModel;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageDataResponseModel;
import com.nikolic.cubes.komentar.databinding.RvItemCategoryboxBinding;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

import java.util.ArrayList;

public class RvItemCategoryBoxSport implements RvItemDetailMain{


    private CategoryBoxResponseModel model;
    private String title;


    public RvItemCategoryBoxSport(CategoryBoxResponseModel model, String title) {
        this.model = model;
        this.title = title;
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public void bind(MainAdapter.MainViewHolder holder) {


        RvItemCategoryboxBinding binding= (RvItemCategoryboxBinding) holder.binding;

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));

        binding.recyclerView.setAdapter(new CategoryBoxAdapter(holder.itemView.getContext(),model.news));
        binding.viewColor.setBackgroundColor(Color.parseColor(model.color));

        binding.textView.setText(title);





    }
}
