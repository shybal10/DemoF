package com.example.mawaqaamobile.festivity.Model;

import com.plumillonforge.android.chipview.Chip;

public class FilterOption implements Chip{
    private String text;
    private boolean isSelected = false;

    public FilterOption(String text) {
        this.text = text;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }


    @Override
    public String getText() {
        return text;
    }
}

