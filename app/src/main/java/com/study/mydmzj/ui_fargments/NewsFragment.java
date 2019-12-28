package com.study.mydmzj.ui_fargments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.study.mydmzj.R;
import com.study.mydmzj.adapters.NewsRecycleViewAdapter;
import com.study.mydmzj.beans.NewsBannerData;
import com.study.mydmzj.utils.RefererUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class NewsFragment extends DaggerFragment {
    @Inject
    NewsViewModel mViewModel;

    private RecyclerView recyclerView;
    private Banner banner;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        recyclerView = view.findViewById(R.id.news_recyclerView);
        banner = view.findViewById(R.id.news_banner);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        NewsRecycleViewAdapter adapter = new NewsRecycleViewAdapter(requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setDelayTime(3000)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(RefererUtil.buildeGlideUrl((String) path)).into(imageView);
                    }
                });
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        mViewModel.getListMutableLiveData().observe(this, newsData -> {
            adapter.setNewsDataList(newsData);
            recyclerView.setAdapter(adapter);
        });
        mViewModel.getMutableLiveData().observe(this, newsBannerData -> {
            List<NewsBannerData.DataBean> dataBeans = newsBannerData.getData();
            List<String> stringList = new ArrayList<>();
            List<String> urlList = new ArrayList<>();
            for (NewsBannerData.DataBean dataBean : dataBeans) {
                stringList.add(dataBean.getTitle());
                urlList.add(dataBean.getPic_url());
            }
            banner.setImages(urlList);
            banner.setBannerTitles(stringList);
            banner.start();


        });

    }

}
