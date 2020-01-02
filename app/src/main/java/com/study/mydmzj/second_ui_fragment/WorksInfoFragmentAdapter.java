package com.study.mydmzj.second_ui_fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WorksInfoFragmentAdapter extends FragmentStateAdapter {
    private Fragment fragment;

    public WorksInfoFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                fragment = new WorkFragmentOne();
                break;
            case 1:
                fragment = new WorkFragmentSecond();
                break;
            case 2:
                fragment = new WorkFragmentThird();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
