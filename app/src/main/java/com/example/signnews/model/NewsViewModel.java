package com.example.signnews.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.signnews.networking.NewsRepository;

public class NewsViewModel extends ViewModel {
    private static String KEY = "65b80ebd2b1e4bbe92f2ca9183bb18a7";
    private MutableLiveData<NewsResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public void topHeadline(String country){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getHeadlineNews(country, KEY);

    }
    public void getNewsEverything(String keyword){
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNewsEverything(keyword, KEY);
    }
    public LiveData<NewsResponse> getNewsRepository() {
        return mutableLiveData;
    }
}
