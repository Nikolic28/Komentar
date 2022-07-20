package com.nikolic.cubes.komentar.data.dataconatinaer;

import com.nikolic.cubes.komentar.data.model.Category;
import com.nikolic.cubes.komentar.data.model.Category2;
import com.nikolic.cubes.komentar.data.model.Comment;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.responsehome.CategoryBoxResponseModel;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageDataResponseModel;

import java.util.ArrayList;

public class DataContainer {

    public static ArrayList<Category2> categoryList = new ArrayList<>();
    public static ArrayList<News> newsList = new ArrayList<>();
    public static ArrayList<News> latestNews = new ArrayList<>();
    public static HomePageDataResponseModel data= new HomePageDataResponseModel();
    public static ArrayList<Comment>commentList = new ArrayList<>();



    public static ArrayList<News> getNewsByCategory(Category2 category2){


        ArrayList<News> list = new ArrayList<>();

        if(category2 == null){
            return newsList;
        }

        for(News news : newsList){
            if(news.category.id==category2.id){
                list.add(news);
            }
        }

        return list;
    }



}
