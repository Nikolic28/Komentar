package com.nikolic.cubes.komentar.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.response.ResponseModel;
import com.nikolic.cubes.komentar.databinding.FragmentSearchBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;
import com.nikolic.cubes.komentar.ui.adapter.NewsAdapter;
import com.nikolic.cubes.komentar.ui.adapter.SearchAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    public  ArrayList<News> searchList = new ArrayList<News>();




    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentSearchBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.imageviewSearch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String term = binding.editText.getText().toString();


                Retrofit retrofit= new Retrofit.Builder()
                        .baseUrl("https://komentar.rs/wp-json/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RetrofitService service = retrofit.create(RetrofitService.class);

                service.getSearch(term).enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        searchList = response.body().data.news;


                        searchNewsRefreshUI(term);


                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {

                    }
                });
            }
        });




    }

    public ArrayList<News> getNewsBySearchTerm(String term){
        ArrayList<News> list = new ArrayList<>();

        if(term == null){
            return searchList;
        }

        for(News news : searchList){
            if(news.title.toLowerCase().contains(term.toLowerCase())||news.category.name.toLowerCase().contains(term.toLowerCase())){
                list.add(news);
            }
        }

        return list;
    }


    private void searchNewsRefreshUI(String term){
        ArrayList<News> list = getNewsBySearchTerm(term);


        if(term.length() < 3){
            Toast.makeText(getContext(),
                    "Tekst mora imati najmanje 3 karaktera!",Toast.LENGTH_SHORT).show();

            list=searchList;

        }
        else{
            list=getNewsBySearchTerm(term);
        }

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(new SearchAdapter(getContext(),list));



    }





}