package com.example.trocker2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdaptateur extends FragmentPagerAdapter {

    private List<Fragment> listFrag = new ArrayList<>();
    private List<String> listTitre = new ArrayList<>();

    public PageAdaptateur(@NonNull FragmentManager mgr) {
        super(mgr);
    }

    public void addFragment(Fragment fragment, String titre){
        listFrag.add(fragment);
        listTitre.add(titre);
    }

    public String getTitre(int position){
        return listTitre.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFrag.get(position);
    }

    @Override
    public int getCount() {
        return listFrag.size();
    }

    public void addFragmentAt(Fragment fragment, int position){
        listFrag.add(position, fragment);
    }
}
