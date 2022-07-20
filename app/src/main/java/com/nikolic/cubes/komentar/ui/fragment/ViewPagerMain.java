package com.nikolic.cubes.komentar.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageDataResponseModel;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageResponseModel;
import com.nikolic.cubes.komentar.databinding.FragmentViewPagerMainBinding;
import com.nikolic.cubes.komentar.databinding.FragmentViewpagerBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ViewPagerMain extends Fragment {


    public HomePageDataResponseModel data;
    public FragmentViewPagerMainBinding binding;

    public ViewPagerMain() {
        // Required empty public constructor
    }


    public static ViewPagerMain newInstance(HomePageDataResponseModel data) {
        ViewPagerMain fragment = new ViewPagerMain();
        fragment.data=data;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentViewPagerMainBinding.inflate(inflater,container,false);





        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(new MainAdapter(DataContainer.data,getContext()));


        super.onViewCreated(view, savedInstanceState);
    }
}