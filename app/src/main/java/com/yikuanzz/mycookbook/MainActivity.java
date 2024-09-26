package com.yikuanzz.mycookbook;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.yikuanzz.mycookbook.fragment.MyFragmentAdapter;
import com.yikuanzz.mycookbook.fragment.OneFragment;
import com.yikuanzz.mycookbook.fragment.ThreeFragment;
import com.yikuanzz.mycookbook.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Button View 创建与绑定
    private ViewPager2 view_pager;    // ViewPager 控件
    private RadioButton radio_one;  // homepage 按钮
    private RadioButton radio_two;  // collection 按钮
    private RadioButton radio_three;  // personalCenter 按钮
    private RadioGroup radio_group;  // RadioGroup 控件

    // initView 绑定控件
    private void initView(){
        view_pager = findViewById(R.id.view_pager);
        radio_one = findViewById(R.id.radio_one);
        radio_two = findViewById(R.id.radio_two);
        radio_three = findViewById(R.id.radio_three);
        radio_group = findViewById(R.id.radio_group);
    }

    // Fragment 创建
    private Fragment oneFragment, twoFragment, threeFragment;
    private final List<Fragment> fragarrList = new ArrayList<>();
    private int position = 0;

    // initData 实例化碎片
    private void initData(){
        Fragment oneFragment = new OneFragment();
        Fragment twoFragment = new TwoFragment();
        Fragment threeFragment = new ThreeFragment();

        fragarrList.add(oneFragment);
        fragarrList.add(twoFragment);
        fragarrList.add(threeFragment);

        MyFragmentAdapter adapter = new MyFragmentAdapter(this, fragarrList);
        view_pager.setAdapter(adapter);    // view_pager 绑定适配器
        ((RadioButton)radio_group.getChildAt(position)).setChecked(true);
    }

    // initMove 滑动屏幕时选中对应按钮
    private void initMove(){
        view_pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                ((RadioButton)radio_group.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    // initOnClick 点击按钮时切换到对应的页面
    private void initOnclick(){
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                position = 0;
                if (i == R.id.radio_two){
                    position = 1;
                } else if (i == R.id.radio_three) {
                    position = 2;
                }
                view_pager.setCurrentItem(position);
            }
        });
    }

    // 调用 initView() initData() initMove() initOnclick() 方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    // 绑定渲染的模板
        initView();     // 初始化控件
        initData();     // 添加碎片到容器
        initMove();     // 滑屏按钮变化
        initOnclick();  // 点击按钮变化
    }
}