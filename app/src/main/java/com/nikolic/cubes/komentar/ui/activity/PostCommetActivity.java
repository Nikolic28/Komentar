package com.nikolic.cubes.komentar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nikolic.cubes.komentar.R;
import com.nikolic.cubes.komentar.data.model.responsecomment.CommentResponseModel;
import com.nikolic.cubes.komentar.databinding.ActivityAllCommentsBinding;
import com.nikolic.cubes.komentar.databinding.ActivityPostCommetBinding;
import com.nikolic.cubes.komentar.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostCommetActivity extends AppCompatActivity {

    ActivityPostCommetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityPostCommetBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String comment= binding.editText2.getText().toString();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://komentar.rs/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        binding.buttonPostComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.postComment(comment).enqueue(new Callback<CommentResponseModel>() {
                    @Override
                    public void onResponse(Call<CommentResponseModel> call, Response<CommentResponseModel> response) {

                        Toast.makeText(view.getContext().getApplicationContext(),"Uspesno ste postavili komentar",Toast.LENGTH_LONG).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<CommentResponseModel> call, Throwable t) {

                    }
                });
            }
        });






    }
}