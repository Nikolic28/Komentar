package com.nikolic.cubes.komentar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.nikolic.cubes.komentar.data.model.News;
import com.nikolic.cubes.komentar.data.model.responsehome.CategoryBoxResponseModel;
import com.nikolic.cubes.komentar.data.model.responsehome.HomePageDataResponseModel;
import com.nikolic.cubes.komentar.databinding.RvItemCategoryboxBinding;
import com.nikolic.cubes.komentar.databinding.RvItemMostBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSliderSliderBinding;
import com.nikolic.cubes.komentar.databinding.RvItemSmallNewsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemTitleNewsBinding;
import com.nikolic.cubes.komentar.databinding.RvItemVideoBinding;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemAktuelno;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemBeograd;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemCategoryBoxSport;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemDetailMain;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemDrustvo;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemEkonomija;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemHoroskop;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemKultura;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemMost;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemPolitika;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemRegion;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemSlider;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemSliderEditor;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemSvet;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemTitleEditorChoice;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemTitleVideo;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemTopNews;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemVesti;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemVideoIntervju;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemVideoMain;
import com.nikolic.cubes.komentar.ui.adapter.detailmain.RvItemZabava;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {



    private HomePageDataResponseModel data;
    private ArrayList<RvItemDetailMain> items;
    private Context context;


    public MainAdapter(HomePageDataResponseModel data, Context context) {
        this.data = data;
        this.context = context;
        this.items= new ArrayList<>();
//slider
        if (data.slider.size()>0) {
            this.items.add(new RvItemSlider(data));
        }
//top
        if (data.top.size()>0) {
            for (News news : this.data.top) {
                this.items.add(new RvItemTopNews(news));
            }
        }
//most
        if (data.most_comented.size()>0&&data.latest.size()>0&&data.most_read.size()>0) {
            this.items.add(new RvItemMost(data));
        }
 //category sport

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Sport")){
                this.items.add(new RvItemCategoryBoxSport(categoryBoxResponseModel,"Sport"));
            }
        }

  //editor choice
        if (data.editors_choice.size()>0){
            this.items.add(new RvItemTitleEditorChoice("Izbor urednika"));
            this.items.add(new RvItemSliderEditor(data));
        }

   //video

        if (data.videos.size()>0){
            this.items.add(new RvItemTitleVideo("VIDEO"));
            for (News news : this.data.videos){
                this.items.add(new RvItemVideoMain(news));
            }
        }

   //category aktuelno

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Aktuelno")){
                this.items.add(new RvItemAktuelno(categoryBoxResponseModel,"Aktuelno"));
            }
        }

   //category Beograd

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Beograd")){
                this.items.add(new RvItemBeograd(categoryBoxResponseModel,"BEOGRAD"));
            }
        }

   //category drustvo

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Drustvo")){
                this.items.add(new RvItemDrustvo(categoryBoxResponseModel,"Drustvo"));
            }
        }

   //category ekonomija

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Ekonomija")){
                this.items.add(new RvItemEkonomija(categoryBoxResponseModel,"Ekonomija"));
            }
        }

   //category horoskop

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Horoskop")){
                this.items.add(new RvItemHoroskop(categoryBoxResponseModel,"Horoskop"));
            }
        }
   //kultura

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Kultura")){
                this.items.add(new RvItemKultura(categoryBoxResponseModel,"Kultura"));
            }
        }
   //politika

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Politika")){
                this.items.add(new RvItemPolitika(categoryBoxResponseModel,"Politika"));
            }
        }
   //region

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Region")){
                this.items.add(new RvItemRegion(categoryBoxResponseModel,"Region"));
            }
        }
    //svet

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Svet")){
                this.items.add(new RvItemSvet(categoryBoxResponseModel,"Svet"));
            }
        }
    //vesti

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Vesti")){
                this.items.add(new RvItemVesti(categoryBoxResponseModel,"Vesti"));
            }
        }

    //video/intervju

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Video/intervju")){
                this.items.add(new RvItemVideoIntervju(categoryBoxResponseModel,"Video/intervju"));
            }
        }

     //zabava

        for (CategoryBoxResponseModel categoryBoxResponseModel:data.category){
            if (categoryBoxResponseModel.title.equalsIgnoreCase("Zabava")){
                this.items.add(new RvItemZabava(categoryBoxResponseModel,"Zabava"));
            }
        }


    }

    @NonNull
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewBinding binding = null ;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 0:
                binding = RvItemSliderSliderBinding.inflate(inflater, parent, false);
                break;
            case 1:
                binding = RvItemSmallNewsBinding.inflate(inflater,parent,false);
                break;
            case 2:
                binding= RvItemMostBinding.inflate(inflater,parent,false);
                break;
            case 3:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 4:
                binding= RvItemTitleNewsBinding.inflate(inflater,parent,false);
                break;
            case 5:
                binding = RvItemSliderSliderBinding.inflate(inflater, parent, false);
                break;
            case 6:
                binding= RvItemTitleNewsBinding.inflate(inflater,parent,false);
                break;
            case 7:
                binding= RvItemVideoBinding.inflate(inflater,parent,false);
                break;
            case 8:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 9:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 10:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 11:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 12:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 13:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 14:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 15:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 16:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 17:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 18:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;
            case 19:
                binding= RvItemCategoryboxBinding.inflate(inflater,parent,false);
                break;


        }

        return  new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder holder, int position) {

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

    public class MainViewHolder extends RecyclerView.ViewHolder{

        public ViewBinding binding;

        public MainViewHolder(ViewBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
