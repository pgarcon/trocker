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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Accueil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Accueil extends Fragment {

    private static int JAIME = 0;
    private static int JAIMEPAS = 0;

    private static final String KEY_POSITION="position";
    private PageAdapteurPoduit adapteur;
    private int pos;
    private ViewPager viewPager;
    private View result;

    private static boolean aBouge = false;

    private int positionCourante = 0;

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
        adapteur = new PageAdapteurPoduit(getActivity().getSupportFragmentManager());
        if (getArguments() != null) {
            pos = getArguments().getInt(KEY_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 3 - Get layout of PageFragment
        result = inflater.inflate(R.layout.fragment_accueil, container, false);

        //PageAdapteurPoduit adapteur = new PageAdapteurPoduit(getActivity().getSupportFragmentManager());

        //AfficherProduit fragment = (AfficherProduit) getChildFragmentManager().findFragmentById(R.id.fragment_prod);

        viewPager = (ViewPager) result.findViewById(R.id.viewPagerProduit);

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
            //this.pageAdaptateur = new PageAdaptateur(getActivity().getSupportFragmentManager());
            //this.pageAdaptateur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Produit1", "mon produit 1"), "AfficherProduit");
            //this.pageAdaptateur.addFragment(AfficherProduit.newInstance(R.drawable.two, "Produit2", "mon produit 2"), "AfficherProduit");
            //this.pageAdaptateur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Produit3", "mon produit 3"), "AfficherProduit");

            // Connecter l'adaptateur de page au ViewPager2
            //viewPager.setAdapter(pageAdaptateur);
            //viewPager.setCurrentItem(1, true);

            adapteur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Produit1", "mon produit 1"));
            adapteur.addFragment(AfficherProduit.newInstance(R.drawable.two, "Produit2", "mon produit 2"));
            adapteur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Produit3", "mon produit 3"));;


            viewPager.setAdapter(adapteur);
        }

        //textView.setText("Bienvenu " + position);
        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        //ViewPager.OnPageChangeListener pager = new ViewPager.OnPageChangeListener();

        // Écouter les événements de changement de page dans le ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int lastSelectedPage = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                positionCourante = position;
                if (position > lastSelectedPage) {
                    lastSelectedPage = position;
                    ajouterProduit(lastSelectedPage);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        ImageView jaime = result.findViewById(R.id.pouceHaut);

        jaime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reagit(JAIME);
            }
        });

        ImageView jaimepas = result.findViewById(R.id.pouceBas);

        jaimepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reagit(JAIMEPAS);
            }
        });

        ImageView jaimetrop = result.findViewById(R.id.coeur);

        jaimetrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reagit(-1);
            }
        });

        return result;
    }


    public void reagit(int valeur){
        if(valeur == JAIME) {
            System.out.println("position : \n " + positionCourante);
            viewPager.setCurrentItem(positionCourante-2);
            adapteur.removeFragment(positionCourante);
            adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.one, "Autre produit", "Description du nouveau produit"), positionCourante+1);
            positionCourante--;

        }else if(valeur == JAIMEPAS){
            System.out.println("position : \n " + positionCourante);

            viewPager.setCurrentItem(positionCourante-2);
            adapteur.removeFragment(positionCourante);
            adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.one, "Autre produit", "Description du nouveau produit"), positionCourante+1);
            positionCourante--;

        }else{

            System.out.println("position : \n " + positionCourante);

            viewPager.setCurrentItem(positionCourante-2);
            adapteur.removeFragment(positionCourante);
            adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.one, "Autre produit", "Description du nouveau produit"), positionCourante+1);
            positionCourante--;

        }
    }

    private void ajouterProduit(int num){
        adapteur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Nouveau produit " + num, "Description du nouveau produit"));
    }

    private void ajouterProduitA(int num, int position){
        adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.one, "Nouveau produit " + num, "Description du nouveau produit"), position);
    }
}