package com.nikolic.cubes.komentar.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.data.model.Category2;
import com.nikolic.cubes.komentar.databinding.FragmentHomeBinding;
import com.nikolic.cubes.komentar.databinding.FragmentNewsBinding;
import com.nikolic.cubes.komentar.ui.adapter.DrawerAdapter;
import com.nikolic.cubes.komentar.ui.adapter.VpAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {



    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding= FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        VpAdapter adapter= new VpAdapter(getActivity().getSupportFragmentManager(),DataContainer.categoryList);
        binding.viewPager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        binding.imageViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawelayout.openDrawer(Gravity.RIGHT);

            }
        });

        binding.imageviewExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawelayout.closeDrawer(Gravity.RIGHT);
            }
        });

        binding.recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView2.setAdapter(new DrawerAdapter(DataContainer.categoryList));





    }
}