package com.nikolic.cubes.komentar.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.response.ResponseModel;
import com.nikolic.cubes.komentar.databinding.FragmentNewsBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.NewsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;





    public NewsFragment() {
        // Required empty public constructor
    }


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentNewsBinding.inflate(inflater,container,false);


        return binding.getRoot();




    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(new NewsAdapter(getContext(), DataContainer.latestNews));




    }
}