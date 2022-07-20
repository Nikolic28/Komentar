package com.nikolic.cubes.komentar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.databinding.ActivityAllCommentsBinding;
import com.nikolic.cubes.komentar.databinding.ActivityHomeMainBinding;
import com.nikolic.cubes.komentar.ui.adapter.MainAdapter;

public class HomeMainActivity extends AppCompatActivity {

    ActivityHomeMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityHomeMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recyclerView.setAdapter(new MainAdapter(DataContainer.data,getApplicationContext()));


        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}