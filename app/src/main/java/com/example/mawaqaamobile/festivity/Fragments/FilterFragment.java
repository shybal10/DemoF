package com.example.mawaqaamobile.festivity.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mawaqaamobile.festivity.Adapters.FilterOptionsRecViewAdapter;
import com.example.mawaqaamobile.festivity.Model.FilterOption;
import com.example.mawaqaamobile.festivity.R;
import com.plumillonforge.android.chipview.Chip;
import com.plumillonforge.android.chipview.ChipView;
import com.plumillonforge.android.chipview.ChipViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FilterFragment extends Fragment {
    private   List<Chip> chipList;
    private MyChipAdapter myChipAdapter;
    public static ChipView chipView;
    private List<FilterOption> filterOptions;
    FilterOptionsRecViewAdapter filterOptionsRecViewAdapter;
    RecyclerView filterOptionsRecyclerView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //using chip library
        myChipAdapter = new MyChipAdapter(getActivity());
        myChipAdapter.setHasBackground(false);
        chipView = (ChipView) view.findViewById(R.id.selected_tags);
        chipView.setAdapter(myChipAdapter);
        myChipAdapter.setChipLayoutRes(R.layout.chip_layout);

        filterOptionsRecyclerView = (RecyclerView) view.findViewById(R.id.filter_options_rec_view);
        filterOptionsRecViewAdapter = new FilterOptionsRecViewAdapter(getActivity(),getListData());
        filterOptionsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        filterOptionsRecyclerView.setHasFixedSize(true);
        filterOptionsRecyclerView.setAdapter(filterOptionsRecViewAdapter);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.filter_fragment_layout, container, false);
    }

    private List<FilterOption> getListData() {
        filterOptions = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            filterOptions.add(new FilterOption("option: "+ i ));
        }
        return filterOptions;
    }


    //    custom chipview Adapter
    private class MyChipAdapter extends ChipViewAdapter{

        public MyChipAdapter(Context context) {
            super(context);
        }

        @Override
        public int getLayoutRes(int position) {
            return R.layout.chip_layout;
        }

        @Override
        public int getBackgroundRes(int position) {
            return 0;
        }

        @Override
        public int getBackgroundColor(int position) {
            return 0;
        }

        @Override
        public int getBackgroundColorSelected(int position) {
            return 0;
        }

        @Override
        public void onLayout(View view, int position) {
        }

    }
}
