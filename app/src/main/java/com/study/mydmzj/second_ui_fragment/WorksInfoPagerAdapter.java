package com.study.mydmzj.second_ui_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.study.mydmzj.R;

import java.util.ArrayList;
import java.util.List;

public class WorksInfoPagerAdapter extends RecyclerView.Adapter {

    private List<String> strings = new ArrayList<>(3);

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    private boolean isExtend = false;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager2_item, parent, false);
        view.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));//不然会报错 Pages must fill the whole ViewPager2 (use match_parent)
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.textView.setOnClickListener(v -> {
            if (isExtend) {
                viewHolder.textView.setMaxLines(2);
                isExtend = false;
            } else {
                viewHolder.textView.setMaxLines(10);
                isExtend = true;
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_txt);
        }
    }
}
