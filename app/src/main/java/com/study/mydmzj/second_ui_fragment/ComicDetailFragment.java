package com.study.mydmzj.second_ui_fragment;

import android.graphics.drawable.Drawable;
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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * 漫画二级目录，显示漫画的具体信息
 */
public class ComicDetailFragment extends DaggerFragment {
    @Inject
    ComicDetailViewModel mViewModel;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    private ImageView imageView_cover;
    private TextView textView_author, textView_type, textView_click_num, textView_subscription_num,
            textView_status, textView_title, textView_description;
    private ImageButton imageButton_back;

    private boolean isExtend = false;

    public static ComicDetailFragment newInstance() {
        return new ComicDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comic_detail_fragment, container, false);
        viewPager2 = view.findViewById(R.id.comic_detail_viewpager);
        tabLayout = view.findViewById(R.id.tabLayout_comic_detail);

        imageButton_back = view.findViewById(R.id.imageButton_back);
        imageView_cover = view.findViewById(R.id.imageView_cover);
        textView_author = view.findViewById(R.id.textView_author);
        textView_type = view.findViewById(R.id.textView_type);
        textView_click_num = view.findViewById(R.id.textView_click_num);
        textView_subscription_num = view.findViewById(R.id.textView_subscription_num);
        textView_status = view.findViewById(R.id.textView_status);
        textView_title = view.findViewById(R.id.textView_title);
        textView_description = view.findViewById(R.id.textView_description);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(ComicDetailViewModel.class);

        int obj_id = getArguments().getInt("obj_id");
        imageButton_back.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigateUp();//返回上一级
        });
        WorksInfoPagerAdapter worksInfoPagerAdapter = new WorksInfoPagerAdapter();

        List<String> list = new ArrayList<>(3);//因为明确知道数组3个元素，所以直接指定。

//在这个里面的那个切页展示数据，一开始想的复杂了，使用了tablayout+viewpager2+fragment，其实用tablayout+viewpager2就可以简单，少了一层通信。另外viewpager2目前版本不成熟，有一些不太理解的错误提示。
        mViewModel.getLiveData(obj_id).observe(this, comicDetailData -> {
            textView_title.setText(comicDetailData.getTitle());//作品标题
            textView_author.setText(comicDetailData.getAuthors().get(0).getTag_name());//作品作者
            textView_type.setText(comicDetailData.getTypes().get(0).getTag_name());//作品类型
            textView_status.setText(comicDetailData.getStatus().get(0).getTag_name());//作品标签
            textView_click_num.setText(new StringBuilder().append("人气 ").append(comicDetailData.getHit_num()).toString());//人气数据
            textView_subscription_num.setText(new StringBuilder().append("订阅 ").append(comicDetailData.getSubscribe_num()).toString());/**订阅数据**/
            Glide.with(this).load(RefererUtil.buildeGlideUrl(comicDetailData.getCover())).into(imageView_cover);/**加载作品封面图**/
            if (comicDetailData.getAuthor_notice() != null) {/** 根据有没有作者公告标签来判断是否需要展示更多数据**/
                list.add(comicDetailData.getDescription());
                list.add(comicDetailData.getComic_notice());
                list.add(comicDetailData.getAuthor_notice());
                textView_description.setVisibility(View.GONE);
                worksInfoPagerAdapter.setStrings(list, requireContext());
                viewPager2.setAdapter(worksInfoPagerAdapter);
                //这个必须放在viewpager加载适配器之后 不然报错TabLayoutMediator attached before ViewPager2 has an adapter
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
            } else {
                viewPager2.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                textView_description.setVisibility(View.VISIBLE);
                textView_description.setText(comicDetailData.getDescription());
            }
        });
        //作品简介的展开与收缩
        textView_description.setOnClickListener(v -> {
            if (isExtend) {
                this.textView_description.setMaxLines(2);
                Drawable drawable = getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black, null);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView_description.setCompoundDrawables(null, null, drawable, null);//给文本后面添加一个图片提示可以展开 收缩
                isExtend = false;
            } else {
                this.textView_description.setMaxLines(10);
                Drawable drawable = getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_black, null);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView_description.setCompoundDrawables(null, null, drawable, null);
                isExtend = true;
            }
        });
        textView_title.setSelected(true);//实现跑马灯这句话必须加上。
        requireActivity().findViewById(R.id.index_bottom_navigation).setVisibility(View.GONE);
    }

}
