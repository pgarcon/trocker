package com.example.trocker2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Accueil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Accueil extends Fragment {

    private static final String KEY_POSITION="position";
    private String pos;
    private ViewPager viewPager;

    public Accueil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Accueil.
     */
    // TODO: Rename and change types and number of parameters
    public static Accueil newInstance(int param1) {
        Accueil fragment = new Accueil();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pos = String.valueOf(getArguments().getInt(KEY_POSITION));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 3 - Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_accueil, container, false);

        AfficherProduit fragment = (AfficherProduit) getChildFragmentManager().findFragmentById(R.id.fragment_prod);
        PageAdaptateur pageAdaptateur = new PageAdaptateur(getActivity().getSupportFragmentManager());

        ViewPager viewPager = (ViewPager) result.findViewById(R.id.viewPagerProduit);

        if(viewPager != null) {
            System.out.println("\n\nnon-null viewpager\n\n");
            if(getView() != null) {
                this.viewPager = getView().findViewById(R.id.viewPagerProduit);
            }
        }else{
            System.out.println("\n\nnull viewpager\n\n");
        }

        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);

        if(viewPager == null){
            System.out.println("\n\nnull\n\n");
        }else {
            pageAdaptateur = new PageAdaptateur(getActivity().getSupportFragmentManager());
            pageAdaptateur.addFragment(AfficherProduit.newInstance("one", "Produit1", "mon produit 1"), "AfficherProduit");
            pageAdaptateur.addFragment(AfficherProduit.newInstance("two", "Produit2", "mon produit 2"), "AfficherProduit");
            pageAdaptateur.addFragment(AfficherProduit.newInstance("three", "Produit3", "mon produit 3"), "AfficherProduit");

            // Connecter l'adaptateur de page au ViewPager2
            viewPager.setAdapter(pageAdaptateur);
        }

        //textView.setText("Bienvenu " + position);
        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewPager = getView().findViewById(R.id.viewPager);
    }
}