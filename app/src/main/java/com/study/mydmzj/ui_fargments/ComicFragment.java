package com.study.mydmzj.ui_fargments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.study.mydmzj.R;

/**
 * 首页，底部的漫画页面
 */
public class ComicFragment extends Fragment {

    private ComicViewModel mViewModel;

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    public static ComicFragment newInstance() {
        return new ComicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comic_fragment, container, false);
        viewPager2 = view.findViewById(R.id.index_viewpager);
        tabLayout = view.findViewById(R.id.index_tablayout);//初始化页面控件
        viewPager2.setAdapter(new RecommendFragmentAdapter(requireActivity()));//配置适配器
        new TabLayoutMediator(tabLayout, viewPager2, true, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("推荐");
                    break;
                case 1:
                    tab.setText("更新");
                    break;
                case 2:
                    tab.setText("分类");
                    break;
                case 3:
                    tab.setText("专题");
                    break;
            }
        }).attach();//第四个参数是将页面与tab layout 的文字对应
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requireActivity().findViewById(R.id.index_bottom_navigation).setVisibility(View.VISIBLE);
        mViewModel = ViewModelProviders.of(this).get(ComicViewModel.class);
        // TODO: Use the ViewModel

    }

}
