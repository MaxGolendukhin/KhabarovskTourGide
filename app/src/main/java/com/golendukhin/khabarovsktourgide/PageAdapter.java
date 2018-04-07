package com.golendukhin.khabarovsktourgide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class PageAdapter extends FragmentPagerAdapter {
    private Context context;

    public PageAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }

    /**
     * @param position of fragment
     * @return fragment for every tab
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MuseumsFragment();
            case 1:
                return new CafeFragment();
            case 2:
                return new ParksFragment();
        }
        return new TheaterFragment();
    }

    /**
     * @return quantity of tabs
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * @param position for which name of tab will be returned
     * @return name of page
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.museums_tab_name);
            case 1:
                return context.getString(R.string.cafes_tab_name);
            case 2:
                return context.getString(R.string.parks_tab_name);
        }
        return context.getString(R.string.theaters_tab_name);
    }
}