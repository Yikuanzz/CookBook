package com.yikuanzz.mycookbook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yikuanzz.mycookbook.R;

public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        assert container != null;
//        TextView textView = new TextView(container.getContext());
//        textView.setText("第二个页面-占位");
//        return textView;
        return inflater.inflate(R.layout.fragment_collection, container, false);
    }
}
