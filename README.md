# Calendar自定义控件使用

* [引用](#引用)
* [控件](#控件)
* [属性](#属性)
* [API](#api)
* [设置date的UI](#设置date的UI)
* [参考网址](#参考网址)


## 引用
build.gradle调用：
```
dependencies {
    compile 'com.sch.calendar:easy-calendar:1.0.1'
}
```

## 控件
xml调用的控件是com.sch.calendar.CalendarView
```
<com.sch.calendar.CalendarView
    android:id="@+id/calendar_view"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>
```


## 属性

|name             | format           | description                         |
| --------------- | ---------------- | ----------------------------------- |
| titleColor      | color            | set color for title                 |
| titleLayout     | reference        | custom layout for title             |
| weekColor       | color            | set color for week                  |
| weekBackground  | color|reference  | set background for week bar         |
| monthBackground | color|reference  | set backgroung for month layout     |
| dateDividerColor| color            | set color for divider of date       |
| dateDividerSize | dimension        | set size for divider of date        |
| imgLastMonth    | reference        | set image for button of last month  |
| imgNextMonth    | reference        | set image for button of next month  |
| language        | enum             | china: 中文, english: English       |



## API

Show or hide overflow date.
```
/**
 * If true, show whole calendar.
 * e.g. showing date is April, if show whole calendar, 03/30 and 05/01 will show.
 */
public void setShowOverflowDate(boolean showOverflowDate);

public boolean isShowOverflowDate();
```

Set format for title.
```
/**
 * Constructs a <code>SimpleDateFormat</code> using the given pattern and
 * the default date format symbols for the given locale.
 * <b>Note:</b> This constructor may not support all locales.
 * For full coverage, use the factory methods in the {@link DateFormat}
 * class.
 *
 * @param pattern the pattern describing the date and time format
 * @param locale  the locale whose date format symbols should be used
 */
public void setTitleFormat(String pattern, Locale locale);
```

Set a listener for callback when date was clicked.
```
/**
 * Set listener for date be clicked.
 *
 * @param onDateClickedListener listener
 */
public void setOnDateClickedListener(OnDateClickedListener onDateClickedListener);
```

Set a listener for callback when showing month changed.
```
/**
 * Set listener for current showing month changed.
 *
 * @param onMonthChangedListener listener
 */
public void setOnMonthChangedListener(final OnMonthChangedListener onMonthChangedListener);
```

Set can or can't change month by drag.设置拖动
```
/**
 * Set drag enable for page.
 */
public void setCanDrag(boolean canDrag);

/**
 * Return drag enable of page.
 */
public boolean canDrag();
```

Set can or can't fling when finger off screen.甩出去松手后是否可以继续滑动
```
/**
 * Set fling enable for page.
 */
public void setCanFling(boolean canFling);

/**
 * Return fling enable of page.
 */
public boolean canFling();
```

Set the visibility of the button for the month of switch.设置上个月和下个月按钮是否显示
```
/**
 * Set button visible for last month.
 *
 * @param visibility {@link Visibility}
 */
public void setLastMonthButtonVisibility(@Visibility int visibility);

/**
 * Set button visible for next month.
 *
 * @param visibility {@link Visibility}
 */
public void setNextMonthButtonVisibility(@Visibility int visibility);
```

Get view of today.(此方法报错，不知道使用方法)
```
/**
 * Return item view of today. If today not showing, return null。
 */
public View getTodayItemView();
```

Set the calendar size will wrap content or not. 
Use this api you can set the calendar size will wrap content or not. 
if true, the layout's height will auto change with animation when month changed.
```
/**
 * Set the layout will wrap content or not.
 *
 * @param scaleEnable if true, the layout will wrap content.
 */
public void setScaleEnable(boolean scaleEnable);
```

## 设置date的UI
默认UI设置：
```
mCalendarView.setVagueAdapter(new SampleVagueAdapter());
```


设置所有参数和数据:
```
mCalendarView.setVagueAdapter(new SampleVagueAdapter()); //设置数据，默认UI
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
```

## 参考网址

[https://github.com/shichaohui/EasyCalendar](https://github.com/shichaohui/EasyCalendar "参考网址")

