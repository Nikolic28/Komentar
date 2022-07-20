package com.nikolic.cubes.komentar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.nikolic.cubes.komentar.data.model.Comment;
import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.responsenewsdetail.DataResponseDetailModel;
import com.nikolic.cubes.komentar.databinding.RvItemCommentBinding;
import com.nikolic.cubes.komentar.databinding.RvItemDetailTagsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemHeaderBinding;
import com.nikolic.cubes.komentar.databinding.RvItemOstaviKomentarBinding;
import com.nikolic.cubes.komentar.databinding.RvItemRecyclerviewCommentsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSviKomentariBinding;
import com.nikolic.cubes.komentar.databinding.RvItemTitleBinding;


import com.nikolic.cubes.komentar.databinding.RvItemTitleNewsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemWebviewBinding;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemComments;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemDetail;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemHeader;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemNewsRelated;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemOstaviKomentar;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemSviKomentari;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemTags;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemTitle;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemTitleKomentar;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemTitleNews;
import com.nikolic.cubes.komentar.ui.adapter.detail.RvItemWebView;


import java.util.ArrayList;

public class NewsDetailAdapter extends RecyclerView.Adapter<NewsDetailAdapter.NewsDetailViewHolder> {

    private Context context;
    private DataResponseDetailModel data;
    private ArrayList<RvItemDetail> items;
    private ArrayList<Comment>commentList;

    public NewsDetailAdapter(Context context, DataResponseDetailModel data,ArrayList<Comment>commentList) {
        this.context = context;
        this.data = data;
        this.items= new ArrayList<>();
        this.commentList=commentList;

        //header
        this.items.add(new RvItemHeader(data));
        //webview
        this.items.add(new RvItemWebView(data));
        //tagovi
        if (data.tags.size()>0) {
            this.items.add(new RvItemTitle("Tagovi"));
            this.items.add(new RvItemTags(data.tags));
        }
        //Komentar


        if (commentList.size()>0) {
            this.items.add(new RvItemTitleKomentar("KOMENTARI"));
            this.items.add(new RvItemOstaviKomentar());
            for (Comment comment : commentList) {
                this.items.add(new RvItemComments(comment));
            }
            this.items.add(new RvItemSviKomentari(commentList));
        }





        //povezane vesti
        if (data.related_news.size()>0){
          this.items.add(new RvItemTitleNews("Povezene vesti"));
            for (News news:this.data.related_news){

               this.items.add(new RvItemNewsRelated(news));

           }


       }




    }

    @NonNull
    @Override
    public NewsDetailAdapter.NewsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewBinding binding = null ;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        switch (viewType){
            case 0:
                binding=RvItemHeaderBinding.inflate(inflater,parent,false);
                break;
            case 1:
                binding=RvItemWebviewBinding.inflate(inflater,parent,false);
                break;
            case 2:
                binding=RvItemTitleBinding.inflate(inflater,parent,false);
                break;
            case 3:
                binding= RvItemDetailTagsBinding.inflate(inflater,parent,false);
                break;
            case 4:
                binding=RvItemTitleBinding.inflate(inflater,parent,false);
                break;
            case 5:
                binding= RvItemOstaviKomentarBinding.inflate(inflater,parent,false);
                break;
            case 6:
                binding= RvItemCommentBinding.inflate(inflater,parent,false);
                break;
            case 7:
                binding= RvItemSviKomentariBinding.inflate(inflater,parent,false);
                break;
            case 8:
                binding= RvItemTitleNewsBinding.inflate(inflater,parent,false);
                break;
            case 9:
                binding= RvItemSmallNewsBinding.inflate(inflater,parent,false);
                break;




        }

        return  new NewsDetailViewHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull NewsDetailAdapter.NewsDetailViewHolder holder, int position) {


        this.items.get(position).bind(holder);



    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return  this.items.get(position).getType();
    }

    public class NewsDetailViewHolder extends RecyclerView.ViewHolder{

            public ViewBinding binding;

        public NewsDetailViewHolder(ViewBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
