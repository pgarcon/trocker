package com.example.trocker2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdaptateur extends FragmentStateAdapter{

    private List<Fragment> listFrag = new ArrayList<>();
    private List<String> listTitre = new ArrayList<>();

    public PageAdaptateur(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return listFrag.get(position);
    }

    @Override
    public int getItemCount() {
        return listFrag.size();
    }

    public void addFragment(Fragment fragment, String titre){
        listFrag.add(fragment);
        listTitre.add(titre);
    }

    public String getTitre(int position){
        return listTitre.get(position);
    }
}
