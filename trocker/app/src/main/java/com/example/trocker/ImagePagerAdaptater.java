package com.example.trocker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ImagePagerAdaptater extends FragmentStatePagerAdapter {
    List<Fragment> list;

    // constructor is called to initialize the objects
    public ImagePagerAdaptater(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    // getCount() is called to return
    // the total number of words to be used
    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
