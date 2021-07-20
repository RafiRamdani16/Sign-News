package com.example.signnews.UI;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
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

public class WorldNewsActivity extends AppCompatActivity {
    ArrayList<NewsArticle> articleArrayList = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView rvHeadline;
    NewsViewModel newsViewModel;
    List<NewsArticle> newsArticles;
    ActionBar back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_news);

        rvHeadline = findViewById(R.id.rvNews);
        back = getSupportActionBar();

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsAdapter = new NewsAdapter(WorldNewsActivity.this, articleArrayList);

        setupToolbar();
        rvHeadline.setLayoutManager(new LinearLayoutManager(this));
        rvHeadline.setAdapter(newsAdapter);
        rvHeadline.setItemAnimator(new DefaultItemAnimator());
        rvHeadline.setNestedScrollingEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        android.widget.SearchView searchView = (android.widget.SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Code here
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    search("");
                } else {
                    search(newText);
                }
                return true;
            }
        });

        return true;
    }

    public void search(String charText) {
        articleArrayList.clear();
        if (charText.length() == 0) {
            articleArrayList.addAll(newsArticles);
        } else {
            newsViewModel.getNewsEverything(charText);
            newsViewModel.getNewsRepository().observe(this, reports -> {
//            // Update the cached copy of the words in the adapter.
                if (reports == null){
                    return;
                }
                newsArticles = reports.getNews();
                articleArrayList.addAll(newsArticles);
            });

        }
        newsAdapter.notifyDataSetChanged();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbNews);
        toolbar.setTitle("World News");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (newsArticles == null){
            articleArrayList.clear();
        }
        else{
            articleArrayList.clear();
            newsArticles.clear();
        }
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (newsArticles == null){
            articleArrayList.clear();
        }
        else{
            articleArrayList.clear();
            newsArticles.clear();
        }
        super.onDestroy();
    }
}
