package com.nikolic.cubes.komentar.data.model.responsenewsdetail;

import com.nikolic.cubes.komentar.data.model.Category;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.Tags;

import java.util.ArrayList;

public class DataResponseDetailModel {

   public int id;
   public String image;
   public String image_source;
   public String author_name;
   public String source;
   public Category category;
   public String title;
   public String description;
   public String comment_enabled;
    public int comments_count;
    public int shares_count;
    public String created_at;
    public String url;
    public String click_type;
    public ArrayList<Tags>tags;
    public ArrayList<News> related_news;
    public ArrayList<News> category_news;
    public ArrayList comments_top_n;


    public DataResponseDetailModel(int id, String image, String image_source, String author_name, String source, Category category, String title, String description, String comment_enabled, int comments_count, int shares_count, String created_at, String url, String click_type, ArrayList<Tags> tags, ArrayList<News> related_news, ArrayList<News> category_news, ArrayList comments_top_n) {
        this.id = id;
        this.image = image;
        this.image_source = image_source;
        this.author_name = author_name;
        this.source = source;
        this.category = category;
        this.title = title;
        this.description = description;
        this.comment_enabled = comment_enabled;
        this.comments_count = comments_count;
        this.shares_count = shares_count;
        this.created_at = created_at;
        this.url = url;
        this.click_type = click_type;
        this.tags = tags;
        this.related_news = related_news;
        this.category_news = category_news;
        this.comments_top_n = comments_top_n;
    }
}
