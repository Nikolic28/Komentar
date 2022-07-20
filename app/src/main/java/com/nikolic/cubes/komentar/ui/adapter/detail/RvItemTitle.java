package com.nikolic.cubes.komentar.ui.adapter.detail;

import com.nikolic.cubes.komentar.data.model.responsenewsdetail.DataResponseDetailModel;
import com.nikolic.cubes.komentar.databinding.RvItemTitleBinding;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

public class RvItemTitle implements  RvItemDetail{


    public String title;

    public RvItemTitle(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return 2;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemTitleBinding binding = (RvItemTitleBinding) holder.binding;

        binding.textView.setText(title);



    }
}
