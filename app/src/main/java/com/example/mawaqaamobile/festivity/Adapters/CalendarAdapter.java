package com.example.mawaqaamobile.festivity.Adapters;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mawaqaamobile.festivity.R;

public class CalendarAdapter extends BaseAdapter {
    private Context mContext;
    TextView dayView;
    ImageView selectedImage;
    private java.util.Calendar month;
    public GregorianCalendar pmonth; // calendar instance for previous month
    /**
     * calendar instance for previous month for getting complete view
     * */
    public GregorianCalendar pmonthmaxset;
    private GregorianCalendar selectedDate;
    int firstDay;
    int maxWeeknumber;
    int maxP;
    int calMaxP;
    int lastWeekDay;
    int leftDays;
    int mnthlength;
    String itemvalue, curentDateString;
    DateFormat df;

    private ArrayList items;
    public static List<String> dayString;
    private View previousView;

    public CalendarAdapter(Context c, GregorianCalendar monthCalendar) {
        CalendarAdapter.dayString = new ArrayList();
        Locale.setDefault(Locale.US);
        month = monthCalendar;
        System.out.println(":::::::::::::::::::::MONTH CALENDAR:::::::::::::::"
                + monthCalendar);
        selectedDate = (GregorianCalendar) monthCalendar.clone();
        mContext = c;
        month.set(GregorianCalendar.DAY_OF_MONTH, 1);

        this.items = new ArrayList();
        df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        curentDateString = df.format(selectedDate.getTime());
        System.out.println(":::::::::::::::::CURRENT DATE STRING::::::::::::::;"
                        + curentDateString);
        refreshDays();
    }

    public void setItems(ArrayList<String> items) {
        for (int i = 0; i != items.size(); i++) {
            if (items.get(i).length() == 1) {
                items.set(i, "0" + items.get(i));
            }
        }
        this.items = items;
    }

    public int getCount() {
        return dayString.size();
    }

    public Object getItem(int position) {
        return dayString.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new view for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            LayoutInflater vi = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.calendar_item, null);

        }
        selectedImage = (ImageView) v.findViewById(R.id.selected_image);
        dayView = (TextView) v.findViewById(R.id.date);

        // separates daystring into parts.
        String[] separatedTime = dayString.get(position).split("-");
        // taking last part of date. ie; 2 from 2012-12-02
        String gridvalue = separatedTime[2].replaceFirst("^0*", "");
        System.out
                .println(":::::::::::::::::::::::ADPTER SPLITTED MONTH:::::::::::::::::::::"
                        + separatedTime[1]);
        // checking whether the day is in current month or not.
        if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
            // setting offdays to white color.
            dayView.setTextColor(Color.parseColor("#CECECE"));
            selectedImage.setVisibility(View.INVISIBLE);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        } else if ((Integer.parseInt(gridvalue) < 7) && (position > 28)) {
            dayView.setTextColor(Color.parseColor("#CECECE"));
            selectedImage.setVisibility(View.INVISIBLE);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        } else {
//            dates in the current month
            if (dayString.get(position).equals(curentDateString)) {
                dayView.setTextColor(Color.WHITE);
                selectedImage.setVisibility(View.VISIBLE);
                setSelected(v);
                previousView = v;
            } else {
                dayView.setTextColor(Color.parseColor("#343434"));
                selectedImage.setVisibility(View.INVISIBLE);
            }
        }

        dayView.setText(gridvalue);

        // create date string for comparison
        String date = (String) dayString.get(position);

        if (date.length() == 1) {
            date = "0" + date;
        }

        String monthStr = "" + (month.get(GregorianCalendar.MONTH));
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }
        return v;
    }

    public View setSelected(View view) {
        if (previousView != null) {
            previousView.findViewById(R.id.selected_image).setVisibility(View.INVISIBLE);
           TextView previoustext = (TextView) previousView.findViewById(R.id.date);
            previoustext.setTextColor(Color.parseColor("#343434"));

            TextView text = (TextView) view.findViewById(R.id.date);
            text.setTextColor(Color.WHITE);
            view.findViewById(R.id.selected_image).setVisibility(View.VISIBLE);
        }
        previousView = view;
    return view;
    }

    public void refreshDays() {
        // clear items
        items.clear();
        dayString.clear();
        Locale.setDefault(Locale.US);
        pmonth = (GregorianCalendar) month.clone();
        // month start day. ie; sun, mon, etc
        firstDay = month.get(GregorianCalendar.DAY_OF_WEEK);
        // finding number of weeks in current month.
        maxWeeknumber = month.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        // allocating maximum row number for the gridview.
        mnthlength = maxWeeknumber * 7;
        maxP = getMaxP(); // previous month maximum day 31,30....
        calMaxP = maxP - (firstDay - 1);// calendar offday starting 24,25 ...
        /**
         * Calendar instance for getting a complete gridview including the three
         * month's (previous,current,next) dates.
         */
        pmonthmaxset = (GregorianCalendar) pmonth.clone();
        /**
         * setting the start date as previous month's required date.
         */
        pmonthmaxset.set(GregorianCalendar.DAY_OF_MONTH, calMaxP);
        /**
         * filling calendar gridview.
         */
        for (int n = 0; n < mnthlength; n++) {
            itemvalue = df.format(pmonthmaxset.getTime());
            pmonthmaxset.add(GregorianCalendar.DATE, 1);
            dayString.add(itemvalue);
        }
    }

    private int getMaxP() {
        int maxP;
        if (month.get(GregorianCalendar.MONTH) == month
                .getActualMinimum(GregorianCalendar.MONTH)) {
            pmonth.set((month.get(GregorianCalendar.YEAR) - 1),
                    month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            pmonth.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) - 1);
        }
        maxP = pmonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

        return maxP;
    }

}