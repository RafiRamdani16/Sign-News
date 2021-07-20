package com.example.signnews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {
    @SerializedName("articles")
    @Expose
    private List<NewsArticle> News = null;

    public List<NewsArticle> getNews() {
        return News;
    }

    public void setNews(List<NewsArticle> news) {
        this.News = news;
    }
}
