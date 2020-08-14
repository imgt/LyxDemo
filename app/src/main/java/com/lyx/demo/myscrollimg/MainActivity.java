package com.lyx.demo.myscrollimg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.lyx.demo.R;
import com.lyx.demo.fragment.FragmentNewProduct;
import com.lyx.demo.fragment.FragmentSecondsOpen;
import com.lyx.demo.fragment.FragmentText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout toolbar_tab;
   // private NoScrollViewPager vp_content;
    private ViewPager vp_content;
    private ViewPagerAdapter vpAdapter;
    private List<Fragment> listFragment = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_t);
        initView();
    }

    //初始化view
    private void initView(){
        //tab
        toolbar_tab = findViewById(R.id.toolbar_tab);
        //
        vp_content = findViewById(R.id.vp_content);

        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(),listFragment);
        vp_content.setAdapter(vpAdapter);
        vp_content.setOffscreenPageLimit(2);
        toolbar_tab.setupWithViewPager(vp_content);
        listFragment.add(FragmentText.newInstance());//添加Fragment
        listFragment.add(FragmentNewProduct.newInstance());
        listFragment.add(FragmentSecondsOpen.newInstance());
//        for(int i=0;i<12;i++){
//            listFragment.add(CeshiFragment.newInstance("第"+i+"页"));
//        }

        vpAdapter.notifyDataSetChanged();

        for(int i=0;i<listFragment.size();i++){
            TabLayout.Tab tab = toolbar_tab.getTabAt(i);
            View customView = LayoutInflater.from(this).inflate(R.layout.tab_text, null, false);
            TextView textView = customView.findViewById(R.id.tv_custom_tab);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            layoutParams.weight = 0;
//            textView.setLayoutParams(layoutParams);
            if (i == 0) {
                textView.setText("推荐");
            } else {
                textView.setText("第"+i+"页");
            }
            if (i == 0) {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textView.setTextColor(getResources().getColor(R.color.color_FFFFC000));
            } else {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                textView.setTextColor(getResources().getColor(R.color._1E1E1E));
            }
            tab.setCustomView(customView);
        }

        toolbar_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (view != null) {
                    TextView textView = view.findViewById(R.id.tv_custom_tab);
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                    textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    textView.setTextColor(getResources().getColor(R.color.color_FFFFC000));
                }
                vp_content.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (view != null) {
                    TextView textView = view.findViewById(R.id.tv_custom_tab);
                    if (textView != null) {
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                        textView.setTextColor(getResources().getColor(R.color._1E1E1E));
                    }
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }
}
