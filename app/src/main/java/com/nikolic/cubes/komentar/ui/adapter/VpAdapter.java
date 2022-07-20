package com.nikolic.cubes.komentar.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.data.model.Category2;
import com.nikolic.cubes.komentar.ui.fragment.ViewPagerMain;
import com.nikolic.cubes.komentar.ui.fragment.ViewpagerFragment;

import java.util.ArrayList;

public class VpAdapter extends FragmentPagerAdapter {


    public ArrayList<Category2>categoryList;



    public VpAdapter(@NonNull FragmentManager fm,ArrayList<Category2>list) {
        super(fm);
        this.categoryList=list;



    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position==0){

            ViewPagerMain fragment = ViewPagerMain.newInstance(DataContainer.data);

            return fragment;

        }
        else if (position==1){

            ViewpagerFragment fragment = ViewpagerFragment.newInstance(DataContainer.latestNews,0);
            return fragment;
        }

        else{
            Category2 category2 = categoryList.get(position-2);
            ViewpagerFragment fragment = ViewpagerFragment.newInstance(DataContainer.getNewsByCategory(category2), category2.id);
            return fragment;
        }
    }

    @Override
    public int getCount() {
        return categoryList.size()+2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0){
            return  "Naslovna";

        }
        else if (position==1){
            return  "Najnovije";

        }
        else {
            Category2 category2 = categoryList.get(position-2);

            return category2.name;
        }
    }
}
