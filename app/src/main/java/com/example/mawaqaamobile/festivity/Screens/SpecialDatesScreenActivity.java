package com.example.mawaqaamobile.festivity.Screens;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mawaqaamobile.festivity.Adapters.CalendarAdapter;
import com.example.mawaqaamobile.festivity.Adapters.SpecialDatesMonthRecViewAdapter;
import com.example.mawaqaamobile.festivity.Popup.SpecialDatesPopup;
import com.example.mawaqaamobile.festivity.R;
import com.example.mawaqaamobile.festivity.UIutills.ViewDetailsGridView;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SpecialDatesScreenActivity extends AppCompatActivity {

    boolean showAllMonths = false;
    ImageButton showMonths;

    RecyclerView specialMonths;
    SpecialDatesMonthRecViewAdapter specialDatesMonthRecViewAdapter;
    public GregorianCalendar month, itemmonth;// calendar instances.

    public CalendarAdapter adapter;// adapter instance
    public Handler handler;// for grabbing some event values for showing the dot
    // marker.
    public ArrayList items; // container to store calendar items which
    // needs showing the event marker

    private TextView day,monthtext,year;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_dates_screen);

//        set up special Dates
        specialMonths = (RecyclerView) findViewById(R.id.special_dates_for_month_rec_view);
        specialDatesMonthRecViewAdapter = new SpecialDatesMonthRecViewAdapter(this,showAllMonths);
        specialMonths.setHasFixedSize(true);
        specialMonths.setLayoutManager(new LinearLayoutManager(this));
        specialMonths.setAdapter(specialDatesMonthRecViewAdapter);

        showMonths = (ImageButton) findViewById(R.id.down_button);
        showMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!showAllMonths) {
                    showAllMonths = true;
                    showMonths.setImageResource(R.drawable.uparrow);
                    specialDatesMonthRecViewAdapter.setShowAllMonths(showAllMonths);
                    specialDatesMonthRecViewAdapter.notifyDataSetChanged();

                }
                else {
                    showAllMonths = false;
                    showMonths.setImageResource(R.drawable.dwnaroow);
                    specialDatesMonthRecViewAdapter.setShowAllMonths(showAllMonths);
                    specialDatesMonthRecViewAdapter.notifyDataSetChanged();
                }
            }
        });


//        set up calender
        Locale.setDefault( Locale.US );
        month = (GregorianCalendar) GregorianCalendar.getInstance();
        itemmonth = (GregorianCalendar) month.clone();

        items = new ArrayList();
        adapter = new CalendarAdapter(this, month);

        ViewDetailsGridView gridview = (ViewDetailsGridView) findViewById(R.id.fixed_calender_gridview);
        gridview.setAdapter(adapter);

        handler = new Handler();
        handler.post(calendarUpdater);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(android.text.format.DateFormat.format("mmmm-yyyy", month));
        day = (TextView) findViewById(R.id.day_text);
        monthtext = (TextView) findViewById(R.id.month_text);
        year = (TextView)  findViewById(R.id.year_txt);

        RelativeLayout previous = (RelativeLayout) findViewById(R.id.previous);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreviousMonth();
                refreshCalendar();
            }
        });

        RelativeLayout next = (RelativeLayout) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextMonth();
                refreshCalendar();
            }
        });

//        gets the date
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id) {
                ((CalendarAdapter) parent.getAdapter()).setSelected(v);
                String selectedGridDate = (String) CalendarAdapter.dayString.get(position);
                String[] separatedTime = selectedGridDate.split("-");
                String gridvalueString = separatedTime[2].replaceFirst("^0*",
                        "");// taking last part of date. ie; 2 from 2012-12-02.
                int gridvalue = Integer.parseInt(gridvalueString);
                // navigate to next or previous month on clicking offdays.
                if ((gridvalue > 10) && (position < 8)) {
                    setPreviousMonth();
                    refreshCalendar();
                } else if ((gridvalue < 7) && (position > 28)) {
                    setNextMonth();
                    refreshCalendar();
                }

                ((CalendarAdapter) parent.getAdapter()).setSelected(v);


                showSpecialDatesPopup();
//                day.setText(separatedTime[2]);
//                monthtext.setText(getMonth(Integer.parseInt(separatedTime[1])));
//                year.setText(separatedTime[0]);
            }
        });
    }

    public void showSpecialDatesPopup() {
        final SpecialDatesPopup dialog = new SpecialDatesPopup(this);
        dialog.setContentView(R.layout.special_dates_popup_dialog);
        dialog.setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(R.color.darkshade);
        dialog.getWindow().setAttributes(lp);
    }

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }

    protected void setNextMonth() {
        if (month.get(GregorianCalendar.MONTH) == month
                .getActualMaximum(GregorianCalendar.MONTH)) {
            month.set((month.get(GregorianCalendar.YEAR) + 1),
                    month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            month.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) + 1);
        }

    }

    protected void setPreviousMonth() {
        if (month.get(GregorianCalendar.MONTH) == month
                .getActualMinimum(GregorianCalendar.MONTH)) {
            month.set((month.get(GregorianCalendar.YEAR) - 1),
                    month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            month.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) - 1);
        }

    }

    protected void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void refreshCalendar() {
        TextView title = (TextView) findViewById(R.id.title);

        adapter.refreshDays();
        adapter.notifyDataSetChanged();

        handler.post(calendarUpdater); // generate some calendar items
        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
    }

    public Runnable calendarUpdater = new Runnable() {

        @Override
        public void run() {
            items.clear();

            // Print dates of the current week
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
            String itemvalue;
            for (int i = 0; i < 7; i++) {
                itemvalue = df.format(itemmonth.getTime());
                itemmonth.add(GregorianCalendar.DATE, 1);
                items.add("2012-09-12");
                items.add("2012-10-07");
                items.add("2012-10-15");
                items.add("2012-10-20");
                items.add("2012-11-30");
                items.add("2012-11-28");
            }

            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


}
