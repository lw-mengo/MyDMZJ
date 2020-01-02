package com.study.mydmzj.second_ui_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.study.mydmzj.R;
import com.study.mydmzj.utils.RefererUtil;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ComicDetailFragment extends DaggerFragment {
    @Inject
    ComicDetailViewModel mViewModel;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    private ImageView imageView_cover;
    private TextView textView_author, textView_type, textView_click_num, textView_subscription_num,
            textView_status, textView_title;
    //            textView, textView2, textView3;
    private ImageButton imageButton_back;

    public static ComicDetailFragment newInstance() {
        return new ComicDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comic_detail_fragment, container, false);
        viewPager2 = view.findViewById(R.id.comic_detail_viewpager);
        tabLayout = view.findViewById(R.id.tabLayout_comic_detail);
//
//        textView = getActivity().getSupportFragmentManager().findFragmentById(R.id.frameLayout_work_one).getView().findViewById(R.id.textView_txt);
//        textView2 = getActivity().getSupportFragmentManager().findFragmentById(R.id.frameLayout_work_second).getView().findViewById(R.id.textView_txt);
//        textView3 = getActivity().getSupportFragmentManager().findFragmentById(R.id.frameLayout_work_third).getView().findViewById(R.id.textView_txt);
        imageButton_back = view.findViewById(R.id.imageButton_back);
        imageView_cover = view.findViewById(R.id.imageView_cover);
        textView_author = view.findViewById(R.id.textView_author);
        textView_type = view.findViewById(R.id.textView_type);
        textView_click_num = view.findViewById(R.id.textView_click_num);
        textView_subscription_num = view.findViewById(R.id.textView_subscription_num);
        textView_status = view.findViewById(R.id.textView_status);
        textView_title = view.findViewById(R.id.textView_title);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(ComicDetailViewModel.class);
        viewPager2.setAdapter(new WorksInfoFragmentAdapter(requireActivity()));
        new TabLayoutMediator(tabLayout, viewPager2, true, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("作品简介");
                    break;
                case 1:
                    tab.setText("作品公告");
                    break;
                case 2:
                    tab.setText("作者公告");
                    break;
            }
        }).attach();
        int obj_id = getArguments().getInt("obj_id");
        imageButton_back.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_comicDetailFragment_to_comicFragment);
        });

        mViewModel.getLiveData(obj_id).observe(this, comicDetailData -> {
            textView_title.setText(comicDetailData.getTitle());
            textView_author.setText(comicDetailData.getAuthors().get(0).getTag_name());
            textView_type.setText(comicDetailData.getTypes().get(0).getTag_name());
            textView_status.setText(comicDetailData.getStatus().get(0).getTag_name());
            textView_click_num.setText(new StringBuilder().append("人气 ").append(comicDetailData.getHit_num()).toString());
            textView_subscription_num.setText(new StringBuilder().append("订阅 ").append(comicDetailData.getSubscribe_num()).toString());
            Glide.with(this).load(RefererUtil.buildeGlideUrl(comicDetailData.getCover())).into(imageView_cover);
        });

        requireActivity().findViewById(R.id.index_bottom_navigation).setVisibility(View.GONE);
    }


}
