package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private TabLayout tabLayout;
    private DrawerLayout drawerLayout;
    private List<Fragment> fragments;
    private Handler handler=new Handler();
    private TextView tv,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininview();
        initviewpager();
    }

    private void initviewpager() {
        //創建list集合
        fragments=new ArrayList<>();
        //添加到fragments集合里
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        //创建适配器
        AppFragmentPageAdapter Adpter=new AppFragmentPageAdapter(getSupportFragmentManager());
        //把fragment添加到adapter
        Adpter.setFragments(fragments);
        //把adapter添加到viewpager
        viewpager.setAdapter(Adpter);

        //tablayout有几个创建几个
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        //是tablayout和viewpager 关联同步一下
        tabLayout.setupWithViewPager(viewpager);
         //设置创建的名字  万物从0开始
        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);
        System.out.println(tabLayout.getTabGravity());
    viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //position 返回下标
            //positionOffset 返回double值过程
            //positionOffsetPixels 返回int值过程
                if(positionOffsetPixels>1&&positionOffsetPixels<500){
                    tv.setBackgroundColor(Color.parseColor("#0099cc"));
                    tv2.setBackgroundResource(R.drawable.main_border);
                }else if(positionOffsetPixels>500) {
                    tv2.setBackgroundColor(Color.parseColor("#0099cc"));
                    tv.setBackgroundResource(R.drawable.main_border);
                }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });


    }



    private void ininview() {
        viewpager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tablelayout);
        tv=findViewById(R.id.main_tv);
        tv2=findViewById(R.id.main_tv2);
    }

}
