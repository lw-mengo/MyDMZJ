package com.study.mydmzj.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.study.mydmzj.R;
import com.study.mydmzj.beans.NewsData;
import com.study.mydmzj.utils.RefererUtil;

import java.util.ArrayList;
import java.util.List;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> {
    private Context context;
    private List<NewsData> newsDataList = new ArrayList<>();

    public NewsRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setNewsDataList(List<NewsData> newsDataList) {
        this.newsDataList = newsDataList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.textView_user.setText(newsDataList.get(position).getNickname());
        holder.textView_title.setText(newsDataList.get(position).getTitle());
        holder.textView_tv_good.setText(String.valueOf(newsDataList.get(position).getMood_amount()));
        holder.textView_tv_comment.setText(String.valueOf(newsDataList.get(position).getComment_amount()));
        Glide.with(context).load(RefererUtil.buildeGlideUrl(newsDataList.get(position).getRow_pic_url()))
                .apply(RefererUtil.getOptions(360, 225))
                .into(holder.imageView_news_cover);
        Glide.with(context).load(RefererUtil.buildeGlideUrl(newsDataList.get(position).getCover()))
                .apply(RefererUtil.getOptions(120, 120))
                .into(holder.imageView_news_user_cover);

    }

    @Override
    public int getItemCount() {
        return newsDataList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_news_cover, imageView_news_user_cover;
        TextView textView_title, textView_tv_good, textView_tv_comment, textView_user;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_news_cover = itemView.findViewById(R.id.news_rv_cover);
            imageView_news_user_cover = itemView.findViewById(R.id.news_rv_user_cover);
            textView_title = itemView.findViewById(R.id.news_rv_tv_title);
            textView_tv_good = itemView.findViewById(R.id.news_rv_tv_good_number);
            textView_tv_comment = itemView.findViewById(R.id.news_rv_tv_comment_number);
            textView_user = itemView.findViewById(R.id.news_rc_tv_user);

        }
    }
}
