package com.example.signnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signnews.UI.DetailNews;
import com.example.signnews.utils.FormatTime;
import com.example.signnews.model.NewsArticle;
import com.example.signnews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    ArrayList<NewsArticle> News;
    
    public NewsAdapter(Context context, ArrayList<NewsArticle> News) {
        this.context = context;
        this.News = News;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {

        holder.tvName.setText(News.get(position).getTitle());
        holder.tvPublised.setText(FormatTime.convertTime(News.get(position).getPublishedAt()));
        holder.tvPublisherName.setText(News.get(position).getPublisherName().getName());
        Picasso.get().load(News.get(position).getUrlToImage())
                .resize(1280,720)
                .into(holder.NewsImage);

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putString("title",News.get(position).getTitle());
                bundle.putString("time",News.get(position).getPublishedAt());
                bundle.putString("image",News.get(position).getUrlToImage());
                bundle.putString("publisher",News.get(position).getPublisherName().getName());
                bundle.putString("author",News.get(position).getAuthor());
                bundle.putString("description",News.get(position).getDescription());
                bundle.putString("url",News.get(position).getUrl());

                Intent intent = new Intent(v.getContext(), DetailNews.class);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return News.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvPublised;
        TextView tvPublisherName;
        ImageView NewsImage;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPublised = itemView.findViewById(R.id.tvPublised);
            tvPublisherName = itemView.findViewById(R.id.tvSource);
            NewsImage = itemView.findViewById(R.id.ivNews);
        }
    }


}
