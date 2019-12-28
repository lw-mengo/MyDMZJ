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
import com.study.mydmzj.beans.TopicData;
import com.study.mydmzj.utils.DateCovertUtil;
import com.study.mydmzj.utils.RefererUtil;

import java.util.ArrayList;
import java.util.List;

public class TopicRecycleViewAdapter extends RecyclerView.Adapter<TopicRecycleViewAdapter.TopicViewHolder> {
    private Context context;
    private List<TopicData> dataList = new ArrayList<>();

    public TopicRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setDataList(List<TopicData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_rv_item, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.textView_topic_title.setText(dataList.get(position).getTitle());
        holder.textView_topic_time.setText(DateCovertUtil.getDate(dataList.get(position).getCreate_time()));
        Glide.with(context).load(RefererUtil.buildeGlideUrl(dataList.get(position).getSmall_cover()))
                .apply(RefererUtil.getOptions(710, 284))
                .into(holder.imageView_topic_cover);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class TopicViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_topic_cover;
        TextView textView_topic_title, textView_topic_time;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_topic_cover = itemView.findViewById(R.id.topic_rv_item_cover);
            textView_topic_time = itemView.findViewById(R.id.topic_rv_item_time);
            textView_topic_title = itemView.findViewById(R.id.topic_rv_item_title);
        }
    }
}
