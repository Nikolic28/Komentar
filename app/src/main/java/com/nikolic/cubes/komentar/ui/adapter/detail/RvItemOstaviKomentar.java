package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.content.Intent;
import android.view.View;

import com.nikolic.cubes.komentar.databinding.RvItemOstaviKomentarBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSviKomentariBinding;
import com.nikolic.cubes.komentar.ui.activity.AllCommentsActivity;
import com.nikolic.cubes.komentar.ui.activity.PostCommetActivity;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

public class RvItemOstaviKomentar implements RvItemDetail{

    public RvItemOstaviKomentar() {
    }

    @Override
    public int getType() {
        return 5;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemOstaviKomentarBinding binding= (RvItemOstaviKomentarBinding) holder.binding;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), PostCommetActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }
}
