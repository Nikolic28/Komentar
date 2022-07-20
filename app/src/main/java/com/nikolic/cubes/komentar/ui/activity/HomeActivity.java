package com.nikolic.cubes.komentar.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.databinding.ActivityHomeBinding;
import com.nikolic.cubes.komentar.databinding.ActivitySplashscreenBinding;
import com.nikolic.cubes.komentar.ui.fragment.HomeFragment;
import com.nikolic.cubes.komentar.ui.fragment.NewsFragment;
import com.nikolic.cubes.komentar.ui.fragment.SearchFragment;
import com.nikolic.cubes.komentar.ui.fragment.VideoFragment;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,HomeFragment.newInstance()).commit();

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                Fragment selectedFragment = null;

                switch (item.getItemId()){

                    case R.id.home:
                        selectedFragment= HomeFragment.newInstance();

                        break;
                    case R.id.search:
                        selectedFragment= SearchFragment.newInstance();
                        break;
                    case R.id.news:
                        selectedFragment= NewsFragment.newInstance();
                        break;
                    case R.id.video:
                        selectedFragment= VideoFragment.newInstance();
                        break;


                }


                getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment).commit();




                return true;
            }
        });





    }
}