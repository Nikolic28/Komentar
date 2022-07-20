package com.nikolic.cubes.komentar.ui.adapter.detail;

import com.nikolic.cubes.komentar.databinding.RvItemTitleNewsBinding;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

public class RvItemTitleNews implements RvItemDetail{

    public String title;

    public RvItemTitleNews(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return 8;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemTitleNewsBinding binding= (RvItemTitleNewsBinding) holder.binding;

        binding.textView.setText(title);

    }
}
