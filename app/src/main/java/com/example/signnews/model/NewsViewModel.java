package com.example.signnews.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.signnews.networking.NewsRepository;

public class NewsViewModel extends ViewModel {
    private static String KEY = "3b35b7950af94d8da344750275f9f4c8";
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
