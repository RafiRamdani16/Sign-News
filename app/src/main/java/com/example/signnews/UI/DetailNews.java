package com.example.signnews.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.signnews.R;
import com.squareup.picasso.Picasso;

public class DetailNews extends AppCompatActivity {

    String titleNews, timeNews, authorNews, publisherNews, imageNews, descriptionNews, urlNews;
    String formattedURL = "sumber: ";
    TextView tvTitleNews;
    TextView tvTimeNews;
    TextView tvAuthorNews;
    TextView tvPublisherNews;
    TextView tvDescriptionNews;
    TextView tvURLNews;
    ImageView tvImageNews;
    Button webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        tvTitleNews = findViewById(R.id.detailTitle);
        tvTimeNews = findViewById(R.id.detailTime);
        tvAuthorNews = findViewById(R.id.Author);
        tvPublisherNews = findViewById(R.id.detailPublisher);
        tvDescriptionNews = findViewById(R.id.detailDescription);
        tvURLNews = findViewById(R.id.detailURL);
        tvImageNews = findViewById(R.id.detailImage);
        webView = findViewById(R.id.bWebView);

        setupToolbar();
        getData();
        setData();


        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailNews.this, NewsWebView.class).putExtra("url", urlNews));
            }
        });
    }

    public void getData(){

        Bundle bundle = getIntent().getExtras();
        if(getIntent().hasExtra("title")
                && getIntent().hasExtra("time")
                && getIntent().hasExtra("image")
                && getIntent().hasExtra("publisher")
                && getIntent().hasExtra("author")
                && getIntent().hasExtra("description")
                && getIntent().hasExtra("url"))
        {
            titleNews = bundle.getString("title");
            timeNews = bundle.getString("time");
            imageNews = bundle.getString("image");
            publisherNews = bundle.getString("publisher");
            authorNews = bundle.getString("author");
            descriptionNews = bundle.getString("description");
            urlNews = bundle.getString("url");

        }
    }

    public void setData(){
        tvTitleNews.setText(titleNews);
        tvTimeNews.setText(timeNews);
        tvAuthorNews.setText(authorNews);
        tvPublisherNews.setText(publisherNews);
        tvDescriptionNews.setText(descriptionNews);
        tvURLNews.setText(formattedURL +urlNews);
        Picasso.get().load(imageNews).fit().centerCrop().into(tvImageNews);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbDetail);
        toolbar.setTitle("Detail News");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
