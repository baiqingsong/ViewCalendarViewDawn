package com.dawn.viewcalendarviewdawn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sch.calendar.CalendarView;
import com.sch.calendar.entity.Date;
import com.sch.calendar.listener.OnDateClickedListener;
import com.sch.calendar.listener.OnMonthChangedListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private CalendarView mCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalendarView = (CalendarView) findViewById(R.id.calendar_view);
        initCalendar();
    }
    private void initCalendar(){
        mCalendarView.setVagueAdapter(new CalendarAdapter()); //设置数据，默认UI
        mCalendarView.setShowOverflowDate(true); //是否显示本页内本月之外的日期
        mCalendarView.setTitleFormat("yyyy-MM", Locale.CHINA); // 设置标题的格式
        mCalendarView.setLastMonthButtonVisibility(View.VISIBLE); //设置上个月按钮不显示
        mCalendarView.setCanDrag(true); //是否可以拖动
        mCalendarView.setCanFling(true); //是否可以甩出
//        mCalendarView.setScaleEnable(true);
        mCalendarView.setOnDateClickedListener(new OnDateClickedListener() {
            @Override
            public void onDateClicked(View itemView, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, year + "年" + month + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });
        mCalendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(Date date) {
                Toast.makeText(MainActivity.this, (date.getMonth() + 1) + "月", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
