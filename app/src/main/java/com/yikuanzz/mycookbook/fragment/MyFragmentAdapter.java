package com.yikuanzz.mycookbook.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragmentList2;

    public MyFragmentAdapter(FragmentActivity fragmentActivity, List<Fragment> fragmentList2){
        super(fragmentActivity);
        this.fragmentList2 = fragmentList2;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList2.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList2.size();
    }
}
