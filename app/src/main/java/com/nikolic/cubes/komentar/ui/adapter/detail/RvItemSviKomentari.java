package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.content.Intent;
import android.view.View;

import com.nikolic.cubes.komentar.data.model.Comment;
import com.nikolic.cubes.komentar.databinding.RvItemSviKomentariBinding;
import com.nikolic.cubes.komentar.ui.activity.AllCommentsActivity;
import com.nikolic.cubes.komentar.ui.activity.NewsDetailActivity;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

import java.util.ArrayList;

public class RvItemSviKomentari implements RvItemDetail{


    ArrayList<Comment> comments;

    public RvItemSviKomentari(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public int getType() {
        return 7;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemSviKomentariBinding binding = (RvItemSviKomentariBinding) holder.binding;

        binding.textViewCommentCount.setText(""+comments.size());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), AllCommentsActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }
}
