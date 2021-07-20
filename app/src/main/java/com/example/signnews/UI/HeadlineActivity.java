package com.example.signnews.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signnews.R;
import com.example.signnews.adapter.NewsAdapter;
import com.example.signnews.model.NewsArticle;
import com.example.signnews.model.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class HeadlineActivity extends AppCompatActivity{
    ArrayList<NewsArticle> articleArrayList = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView rvHeadline;
    NewsViewModel newsViewModel;
    List<NewsArticle> newsArticles;
    String code_country = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_news);

        rvHeadline = findViewById(R.id.rvNews);

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        code_country = getIntent().getStringExtra("country");

        setNews(code_country);
        setupToolbar();

        newsAdapter = new NewsAdapter(HeadlineActivity.this, articleArrayList);
        rvHeadline.setLayoutManager(new LinearLayoutManager(this));
        rvHeadline.setAdapter(newsAdapter);
        rvHeadline.setItemAnimator(new DefaultItemAnimator());
        rvHeadline.setNestedScrollingEnabled(true);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbNews);
        toolbar.setTitle("Breaking News");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        articleArrayList.clear();
        newsArticles.clear();
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        articleArrayList.clear();
        newsArticles.clear();
        super.onDestroy();
    }

    public void setNews(String codeCountry){
        newsViewModel.topHeadline(codeCountry);
        newsViewModel.getNewsRepository().observe(this, newsResponse -> {
            newsArticles = newsResponse.getNews();
            articleArrayList.addAll(newsArticles);
            newsAdapter.notifyDataSetChanged();
        });
    }
}
