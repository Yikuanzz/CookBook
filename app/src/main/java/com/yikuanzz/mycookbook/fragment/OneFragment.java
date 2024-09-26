package com.yikuanzz.mycookbook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yikuanzz.mycookbook.R;

public class OneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Log.d("Debug", "ViewGroup is null:" + (container == null));
//        assert container != null;
//        TextView textView = new TextView(container.getContext());
//        textView.setText("第一个页面-占位");
//        return textView;
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }
}
