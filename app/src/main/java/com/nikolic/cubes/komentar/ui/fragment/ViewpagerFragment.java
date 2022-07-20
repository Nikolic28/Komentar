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
import com.nikolic.cubes.komentar.data.model.Category2;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.response.ResponseModel;
import com.nikolic.cubes.komentar.databinding.FragmentSearchBinding;
import com.nikolic.cubes.komentar.databinding.FragmentViewpagerBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.NewsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewpagerFragment extends Fragment {


    public FragmentViewpagerBinding binding;
    public ArrayList<News>newsList;

    public int id;

    public ViewpagerFragment() {

    }

    public static ViewpagerFragment newInstance(ArrayList<News>list,int id) {
        ViewpagerFragment fragment = new ViewpagerFragment();
        fragment.newsList=list;
        fragment.id=id;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentViewpagerBinding.inflate(inflater,container,false);

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        service.getCategoryNews(id).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                DataContainer.newsList= response.body().data.news;


                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.recyclerView.setAdapter(new NewsAdapter(getContext(),DataContainer.newsList));

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });


        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }



}