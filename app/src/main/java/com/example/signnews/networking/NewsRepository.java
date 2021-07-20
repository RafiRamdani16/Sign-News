package com.example.signnews.networking;

import androidx.lifecycle.MutableLiveData;

import com.example.signnews.model.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private static NewsRepository newsRepository;
    MutableLiveData<NewsResponse> newsData = new MutableLiveData<>();
    private NewsAPI newsApi;

    public static NewsRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    public NewsRepository(){
        newsApi = RetrofitService.createService(NewsAPI.class);
    }

    public MutableLiveData<NewsResponse> getHeadlineNews(String country, String key){
        newsApi.getHeadlineNews(country, key).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call,
                                   Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }

    public MutableLiveData<NewsResponse> getNewsEverything(String keyword, String key) {
        newsApi.getNewsEverything(keyword, key).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call,
                                   Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }

}
