package com.example.shaliniverma.stackoverflow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class pagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public pagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                your tab1 = new your();
                return tab1;
            case 1:
                hot tab2 = new hot();
                return tab2;
            case 2:
                week tab3 = new week();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
