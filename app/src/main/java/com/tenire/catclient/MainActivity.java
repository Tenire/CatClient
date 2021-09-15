package com.tenire.catclient;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainActivity extends Activity {

    /*
    MODE:
        day R.layout.viewpager_day_item default
        week R.layout.viewpager_week_item
        month R.layout.viewpager_month_item
        year R.layout.viewpager_year_item
     */
    static int MODE = R.layout.viewpager_day_item;

    ArrayList<View> list;

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;

    Button button_day;
    Button button_week;
    Button button_month;
    Button button_year;



    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //沉浸
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(Color.rgb(0XEE,0XEE,0XEE));

        setContentView(R.layout.activity_main);

        //初始化
        button_day = (Button)findViewById(R.id.button_day);
        button_week = (Button)findViewById(R.id.button_week);
        button_month = (Button)findViewById(R.id.button_month);
        button_year = (Button)findViewById(R.id.button_year);

        button_day.setTag(R.layout.viewpager_day_item);
        button_week.setTag(R.layout.viewpager_week_item);
        button_month.setTag(R.layout.viewpager_month_item);
        button_year.setTag(R.layout.viewpager_year_item);

        //点击监听器
        MyClickListener myClickListener = new MyClickListener();

        //添加监听
        button_day.setOnClickListener(myClickListener);
        button_week.setOnClickListener(myClickListener);
        button_month.setOnClickListener(myClickListener);
        button_year.setOnClickListener(myClickListener);

        //获取数据
        list = getList();

        viewPager = (ViewPager)findViewById(R.id.main_viewpager);

        //适配器
        myPagerAdapter = new MyPagerAdapter();

        //添加适配器
        viewPager.setAdapter(myPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    public ArrayList<View> getList() {
        list = new ArrayList<View>();
        LinearLayout linearLayout = (LinearLayout)getLayoutInflater().inflate(MODE, null);
        list.add(linearLayout);
        if(MODE == R.layout.viewpager_week_item)
        {
            BarChart barChart = (BarChart)linearLayout.findViewById(R.id.barChartweek);
            barChart.setNoDataText("正在加载中");

            List<BarEntry> list=new ArrayList<>();

            list.add(new BarEntry(1, 3));
            list.add(new BarEntry(2, 8));
            list.add(new BarEntry(3, 6));
            list.add(new BarEntry(4, 9));
            list.add(new BarEntry(5, 5));
            list.add(new BarEntry(6, 1));
            list.add(new BarEntry(7, 10));

            BarDataSet barDataSet=new BarDataSet(list, "猫粮");
            BarData barData=new BarData(barDataSet);
            barChart.setData(barData);

            barChart.getLegend().setEnabled(false);
            barChart.getDescription().setEnabled(false);
            barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart.getXAxis().setDrawGridLines(false);
            barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(){
                @Override
                public String getFormattedValue(float value) {
                    String text = "周一";
                    switch ((int)value)
                    {
                        case 1:
                            text = "周一";
                            break;
                        case 2:
                            text = "周二";
                            break;
                        case 3:
                            text = "周三";
                            break;
                        case 4:
                            text = "周四";
                            break;
                        case 5:
                            text = "周五";
                            break;
                        case 6:
                            text = "周六";
                            break;
                        case 7:
                            text = "周日";
                            break;
                    }
                    return text;
                }
            });
            barChart.getAxisRight().setEnabled(false);
            barChart.getAxisLeft().setEnabled(false);


        }

        linearLayout = (LinearLayout)getLayoutInflater().inflate(MODE, null);
        list.add(linearLayout);
        if(MODE == R.layout.viewpager_week_item)
        {
            BarChart barChart = (BarChart)linearLayout.findViewById(R.id.barChartweek);
            barChart.setNoDataText("正在加载中");

            List<BarEntry> list=new ArrayList<>();

            list.add(new BarEntry(1, 3));
            list.add(new BarEntry(2, 8));
            list.add(new BarEntry(3, 6));
            list.add(new BarEntry(4, 9));
            list.add(new BarEntry(5, 5));
            list.add(new BarEntry(6, 1));
            list.add(new BarEntry(7, 10));

            BarDataSet barDataSet=new BarDataSet(list, "猫粮");
            BarData barData=new BarData(barDataSet);
            barChart.setData(barData);

            barChart.getLegend().setEnabled(false);
            barChart.getDescription().setEnabled(false);
            barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart.getXAxis().setDrawGridLines(false);
            barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(){
                @Override
                public String getFormattedValue(float value) {
                    String text = "周一";
                    switch ((int)value)
                    {
                        case 1:
                            text = "周一";
                            break;
                        case 2:
                            text = "周二";
                            break;
                        case 3:
                            text = "周三";
                            break;
                        case 4:
                            text = "周四";
                            break;
                        case 5:
                            text = "周五";
                            break;
                        case 6:
                            text = "周六";
                            break;
                        case 7:
                            text = "周日";
                            break;
                    }
                    return text;
                }
            });
            barChart.getAxisRight().setEnabled(false);
            barChart.getAxisLeft().setEnabled(false);


        }
        return list;
    }


    class MyPagerAdapter extends PagerAdapter
    {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(list.get(position));
        }
    }

    class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (MODE)
            {
                case R.layout.viewpager_day_item:
                    button_day.setBackgroundResource(R.drawable.button_corner_gray);
                    break;
                case R.layout.viewpager_week_item:
                    button_week.setBackgroundResource(R.drawable.button_corner_gray);
                    break;
                case R.layout.viewpager_month_item:
                    button_month.setBackgroundResource(R.drawable.button_corner_gray);
                    break;
                case R.layout.viewpager_year_item:
                    button_year.setBackgroundResource(R.drawable.button_corner_gray);
                    break;
            }
            MODE = (int)v.getTag();
            list = getList();
            viewPager.setAdapter(myPagerAdapter);
            v.setBackgroundResource(R.drawable.button_corner_white);
        }
    }
}