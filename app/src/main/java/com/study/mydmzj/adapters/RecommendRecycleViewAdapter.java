package com.study.mydmzj.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.study.mydmzj.R;
import com.study.mydmzj.beans.RecommendData;

import java.util.ArrayList;
import java.util.List;

public class RecommendRecycleViewAdapter extends RecyclerView.Adapter {
    private final int VIEW_TYPE_ONE = 1;
    private final int VIEW_TYPE_TWO = 2;
    private Context context;
    private List<RecommendData> recommendData = new ArrayList<>();

    public void setRecommendData(List<RecommendData> recommendData) {
        this.recommendData = recommendData;
    }

    public RecommendRecycleViewAdapter(Context context) {
        this.context = context;
    }

    /**
     * 为glide添加一个header，绕过防盗链
     *
     * @param url 图片url
     * @return 返回加了header的新的请求
     */
    private GlideUrl buildGlideUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        } else {
            return new GlideUrl(url, new LazyHeaders.Builder()
                    .addHeader("Referer", "http://v3api.dmzj.com/")
                    .build());
        }
    }

    /**
     * 通过glide设置圆角
     *
     * @return
     */
    private RequestOptions getOptions() {
        RoundedCorners roundedCorners = new RoundedCorners(20);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(255, 195);
        return options;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_ONE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_rv_item_one, parent, false);
            return new RecommendDataListViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_rv_item_two, parent, false);
            return new GameDataViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecommendDataListViewHolder) {
            RecommendDataListViewHolder viewHolder = (RecommendDataListViewHolder) holder;
            viewHolder.textView_first.setText(recommendData.get(1).getData().get(0).getTitle());
            viewHolder.textView_second.setText(recommendData.get(1).getData().get(1).getTitle());
            viewHolder.textView_third.setText(recommendData.get(1).getData().get(2).getTitle());
            viewHolder.textView_author_first.setText(recommendData.get(1).getData().get(0).getSub_title());
            viewHolder.textView_author_second.setText(recommendData.get(1).getData().get(1).getSub_title());
            viewHolder.textView_author_third.setText(recommendData.get(1).getData().get(2).getSub_title());
            Glide.with(context).load(buildGlideUrl(recommendData.get(1).getData().get(0).getCover()))
                    .apply(getOptions())
                    .into(((RecommendDataListViewHolder) holder).imageView_first);
            Glide.with(context).load(buildGlideUrl(recommendData.get(1).getData().get(1).getCover()))
                    .apply(getOptions())
                    .into(((RecommendDataListViewHolder) holder).imageView_second);
            Glide.with(context).load(buildGlideUrl(recommendData.get(1).getData().get(2).getCover()))
                    .apply(getOptions())
                    .into(((RecommendDataListViewHolder) holder).imageView_third);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return recommendData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_ONE;
        } else if (position == 1) {
            return VIEW_TYPE_TWO;
        } else {
            return super.getItemViewType(position);
        }
    }

    /**
     * 第一个item的view holder
     */
    static class RecommendDataListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_first, imageView_second, imageView_third;
        TextView textView_first, textView_second, textView_third,
                textView_author_first, textView_author_second, textView_author_third;

        public RecommendDataListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_first = itemView.findViewById(R.id.imageView_first);
            imageView_second = itemView.findViewById(R.id.imageView_second);
            imageView_third = itemView.findViewById(R.id.imageView_thrid);
            textView_first = itemView.findViewById(R.id.textView_title_first);
            textView_second = itemView.findViewById(R.id.textView_title_second);
            textView_third = itemView.findViewById(R.id.textView_title_third);
            textView_author_first = itemView.findViewById(R.id.textView_author_first);
            textView_author_second = itemView.findViewById(R.id.textView_author_second);
            textView_author_third = itemView.findViewById(R.id.textView_author_third);
        }
    }

    /**
     * 第二个item的view holder
     */

    static class GameDataViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_one, imageView_two, imageView_third, imageView_fourth;
        TextView textView_one, textView_two, textView_third, textView_fourth;

        public GameDataViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView_one = itemView.findViewById(R.id.imageView_one);
            imageView_two = itemView.findViewById(R.id.imageView_two);
            imageView_third = itemView.findViewById(R.id.imageView_third);
            imageView_fourth = itemView.findViewById(R.id.imageView_fourth);
        }
    }
}
