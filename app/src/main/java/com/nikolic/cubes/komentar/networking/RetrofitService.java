package com.nikolic.cubes.komentar.networking;

import com.nikolic.cubes.komentar.data.model.Comment;
import com.nikolic.cubes.komentar.data.model.responsecategory.ResponseCategory;
import com.nikolic.cubes.komentar.data.model.response.ResponseModel;
import com.nikolic.cubes.komentar.data.model.responsecomment.CommentResponseModel;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageResponseModel;
import com.nikolic.cubes.komentar.data.model.responsenewsdetail.ResponseDetailModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {


    @GET("api/latest")
    Call<ResponseModel>getLatestNews();

    @GET("api/videos")
    Call<ResponseModel>getVideo();

    @GET("api/search")
    Call<ResponseModel>getSearch(@Query("search_parameter")String search_parameter);

    @GET("api/newsdetails")
    Call<ResponseDetailModel>getNewsDetail(@Query("id")int id);

    @GET("api/categories")
    Call<ResponseCategory>getCategory();

    @GET("api/category/{id}")
    Call<ResponseModel> getCategoryNews(@Path("id") int id);

    @GET("api/homepage")
    Call<HomePageResponseModel>getHomePage();

    @GET("api/tag")
    Call<ResponseModel>getTags(@Query("tag")int tag);

    @GET("api/comments")
    Call<CommentResponseModel>getComments(@Query("id")int id);

    @POST("api/commentvote")
    Call<CommentResponseModel>like(@Query("comment")int id,@Query("vote")boolean vote);

    @POST("api/commentvote")
    Call<CommentResponseModel>dislike(@Query("comment")int id,@Query("downvote")boolean vote);

    @POST("api/commentinsert")
    Call<CommentResponseModel>postComment(@Query("comment")String comment);


}
