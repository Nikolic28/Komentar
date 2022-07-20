package com.nikolic.cubes.komentar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.dataconatinaer.DataContainer;
import com.nikolic.cubes.komentar.databinding.ActivityAllCommentsBinding;
import com.nikolic.cubes.komentar.databinding.ActivityHomeBinding;
import com.nikolic.cubes.komentar.ui.adapter.detail.CommentsAdapter;

public class AllCommentsActivity extends AppCompatActivity {

    ActivityAllCommentsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAllCommentsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);




        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recyclerView.setAdapter(new CommentsAdapter(DataContainer.commentList));


        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}