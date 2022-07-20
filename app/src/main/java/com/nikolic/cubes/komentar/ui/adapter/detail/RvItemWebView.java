package com.nikolic.cubes.komentar.ui.adapter.detail;

import android.webkit.WebViewClient;

import com.nikolic.cubes.komentar.data.model.responsenewsdetail.DataResponseDetailModel;
import com.nikolic.cubes.komentar.databinding.RvItemWebviewBinding;
import com.nikolic.cubes.komentar.ui.adapter.NewsDetailAdapter;

public class RvItemWebView implements RvItemDetail {


    private DataResponseDetailModel data;

    public RvItemWebView(DataResponseDetailModel data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public void bind(NewsDetailAdapter.NewsDetailViewHolder holder) {

        RvItemWebviewBinding binding = (RvItemWebviewBinding) holder.binding;
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(data.url);

    }
}
