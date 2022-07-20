package com.nikolic.cubes.komentar.ui.adapter.detailmain;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.nikolic.cubes.komentar.data.model.responsehome.HomePageDataResponseModel;
import com.nikolic.cubes.komentar.databinding.RvItemSliderSliderBinding;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

public class RvItemSliderEditor implements RvItemDetailMain{

    private HomePageDataResponseModel data;
    PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();

    public RvItemSliderEditor(HomePageDataResponseModel data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return 5;
    }

    @Override
    public void bind(MainAdapter.MainViewHolder holder) {

        RvItemSliderSliderBinding binding = (RvItemSliderSliderBinding) holder.binding;

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), RecyclerView.HORIZONTAL,false));

        binding.recyclerView.setAdapter(new RvItemSliderEditorAdapet(data.editors_choice));



  pagerSnapHelper.attachToRecyclerView(binding.recyclerView);

        binding.indicator.attachToRecyclerView(binding.recyclerView, pagerSnapHelper);

    }
}
