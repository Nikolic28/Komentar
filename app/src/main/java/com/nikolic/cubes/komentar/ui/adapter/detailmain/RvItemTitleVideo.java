package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.graphics.Color;

import com.nikolic.cubes.komentar.databinding.RvItemTitleNewsBinding;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

public class RvItemTitleVideo implements RvItemDetailMain{


    public String title;

    public RvItemTitleVideo(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return 6;
    }

    @Override
    public void bind(MainAdapter.MainViewHolder holder) {

        RvItemTitleNewsBinding binding= (RvItemTitleNewsBinding) holder.binding;

        binding.textView.setText(title);
        binding.viewColor.setBackgroundColor(Color.parseColor("#FE0000"));
        holder.itemView.setBackgroundColor(Color.parseColor("#0F2039"));
        binding.textView.setTextColor(Color.parseColor("#FFFFFFFF"));

    }
}
