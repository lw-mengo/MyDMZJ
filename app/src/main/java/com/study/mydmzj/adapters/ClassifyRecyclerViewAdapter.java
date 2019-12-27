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
import com.study.mydmzj.beans.ClassifyData;
import com.study.mydmzj.utils.RefererUtil;

import java.util.ArrayList;
import java.util.List;

public class ClassifyRecyclerViewAdapter extends RecyclerView.Adapter<ClassifyRecyclerViewAdapter.ClassifyViewHolder> {

    private Context context;
    private List<ClassifyData> list = new ArrayList<>();

    public void setList(List<ClassifyData> list) {
        this.list = list;
    }

    public ClassifyRecyclerViewAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ClassifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_rv_item, parent, false);
        return new ClassifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassifyViewHolder holder, int position) {
        holder.textView_title.setText(list.get(position).getTitle());
        Glide.with(context).load(RefererUtil.buildeGlideUrl(list.get(position).getCover()))
                .apply(RefererUtil.getOptions())
                .into(holder.imageView_cover);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ClassifyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_cover;
        TextView textView_title;

        public ClassifyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_cover = itemView.findViewById(R.id.imageView_cover);
            textView_title = itemView.findViewById(R.id.textView_title);
        }
    }
}
