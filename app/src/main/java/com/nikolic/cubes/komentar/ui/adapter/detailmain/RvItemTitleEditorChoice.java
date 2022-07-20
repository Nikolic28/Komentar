package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.graphics.Color;

import com.nikolic.cubes.komentar.databinding.RvItemTitleNewsBinding;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

public class RvItemTitleEditorChoice implements RvItemDetailMain{

    public String title;

    public RvItemTitleEditorChoice(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public void bind(MainAdapter.MainViewHolder holder) {

        RvItemTitleNewsBinding binding= (RvItemTitleNewsBinding) holder.binding;

        binding.textView.setText(title);
        binding.viewColor.setBackgroundColor(Color.parseColor("#FE0000"));

    }
}
