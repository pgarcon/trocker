package com.example.trocker2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Application extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        ViewPager viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.navbar);
        //bottomNavigationView.setItemIconTintList(null);

        PageAdaptateur pageAdaptateur = new PageAdaptateur(getSupportFragmentManager());
        pageAdaptateur.addFragment(Accueil.newInstance(1), "Accueil");
        pageAdaptateur.addFragment(Produits.newInstance(2), "Produits");
        pageAdaptateur.addFragment(Trocks.newInstance(3), "Produits");
        pageAdaptateur.addFragment(Profile.newInstance(4), "Profile");

        // Connecter l'adaptateur de page au ViewPager2
        viewPager.setAdapter(pageAdaptateur);

        // Écouter les événements de sélection d'élément dans la barre de navigation
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.barreTacheImage1:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.barreTacheImage2:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.barreTacheImage3:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.barreTacheImage4:
                        viewPager.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });

        // Écouter les événements de changement de page dans le ViewPager
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Sélectionner l'élément correspondant dans la barre de navigation
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}