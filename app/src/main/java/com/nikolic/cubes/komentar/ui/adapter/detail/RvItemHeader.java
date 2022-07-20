package com.nikolic.cubes.komentar.ui.adapter.detail;

import com.nikolic.cubes.komentar.data.model.responsenewsdetail.DataResponseDetailModel;
import com.nikolic.cubes.komentar.databinding.RvItemHeaderBinding;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

public class RvItemHeader implements RvItemDetail{

    private DataResponseDetailModel data;

    public RvItemHeader(DataResponseDetailModel data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemHeaderBinding binding = (RvItemHeaderBinding) holder.binding;

        binding.textViewTitle1.setText(data.title);
        binding.textViewDate.setText(data.created_at.substring(0,16));
        binding.textViewDescription.setText(data.description);
        binding.textViewCommentCount.setText(""+data.comments_count);
        binding.textViewAuthor.setText(data.author_name);
        binding.textViewIzvor.setText(data.source);

    }
}
