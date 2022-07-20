package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import android.graphics.Color;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageDataResponseModel;
import com.nikolic.cubes.komentar.databinding.RvItemMostBinding;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

import java.util.ArrayList;

public class RvItemMost implements RvItemDetailMain{

    private HomePageDataResponseModel data;

    public RvItemMost(HomePageDataResponseModel data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return 2;
    }

    @Override
    public void bind(MainAdapter.MainViewHolder holder) {

        RvItemMostBinding binding = (RvItemMostBinding) holder.binding;

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        binding.recyclerView.setAdapter(new RvItemSmallNewsAdapter(data.latest));

        binding.buttonLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
                binding.recyclerView.setAdapter(new RvItemSmallNewsAdapter(data.latest));

                binding.buttonComments.setTextColor(Color.parseColor("#88909D"));
                binding.viewComments.setBackgroundColor(Color.parseColor("#88909D"));

                binding.buttonLatest.setTextColor(Color.parseColor("#FF000000"));
                binding.viewLatest.setBackgroundColor(Color.parseColor("#FF0000"));

                binding.buttonMostread.setTextColor(Color.parseColor("#88909D"));
                binding.viewMostread.setBackgroundColor(Color.parseColor("#88909D"));



            }
        });
        binding.buttonMostread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
                binding.recyclerView.setAdapter(new RvItemSmallNewsAdapter(data.most_read));

                binding.buttonComments.setTextColor(Color.parseColor("#88909D"));
                binding.viewComments.setBackgroundColor(Color.parseColor("#88909D"));

                binding.buttonLatest.setTextColor(Color.parseColor("#88909D"));
                binding.viewLatest.setBackgroundColor(Color.parseColor("#88909D"));

                binding.buttonMostread.setTextColor(Color.parseColor("#FF000000"));
                binding.viewMostread.setBackgroundColor(Color.parseColor("#FF0000"));



            }
        });

        binding.buttonComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
                binding.recyclerView.setAdapter(new RvItemSmallNewsAdapter(data.most_comented));

                binding.buttonComments.setTextColor(Color.parseColor("#FF000000"));
                binding.viewComments.setBackgroundColor(Color.parseColor("#FF0000"));

                binding.buttonLatest.setTextColor(Color.parseColor("#88909D"));
                binding.viewLatest.setBackgroundColor(Color.parseColor("#88909D"));

                binding.buttonMostread.setTextColor(Color.parseColor("#88909D"));
                binding.viewMostread.setBackgroundColor(Color.parseColor("#88909D"));



            }
        });


    }
}
