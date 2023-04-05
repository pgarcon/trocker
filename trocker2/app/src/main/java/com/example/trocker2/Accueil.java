package com.example.trocker2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Accueil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Accueil extends Fragment {

    private static int JAIME = 0;
    private static int JAIMEPAS = 1;

    private static final String KEY_POSITION="position";
    private PageAdapteurPoduit adapteur;
    private int pos;
    private ViewPager viewPager;
    private View result;

    private static boolean aBouge = false;

    private boolean informatiqueEtat;
    private boolean domotiqueEtat;
    private boolean electromenagerEtat;
    private boolean jouetEtat;
    private boolean jeuxVideoEtat;
    private boolean plantesEtat;

    CheckBox informatique;
    CheckBox domotique;
    CheckBox electromenager;
    CheckBox jouet;
    CheckBox jeuxVideo;
    CheckBox plantes;

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

        Button button = getActivity().findViewById(R.id.filtreButton);

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

            adapteur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Produit1", "mon produit 1"));
            adapteur.addFragment(AfficherProduit.newInstance(R.drawable.two, "Produit2", "mon produit 2"));
            adapteur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Produit3", "mon produit 3"));;


            viewPager.setAdapter(adapteur);
        }

        //textView.setText("Bienvenu " + position);
        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);


        // Écouter les événements de changement de page dans le ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int lastSelectedPage = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                positionCourante = position;
                System.out.println("\nposition courante : " + position + "\n");
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

        Button buttonFiltre = result.findViewById(R.id.filtreButton);
        buttonFiltre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afficherPopup();

                if(informatiqueEtat){
                    informatique.setChecked(true);
                }
                if(domotiqueEtat){
                    domotique.setChecked(true);
                }
                if(electromenagerEtat){
                    electromenager.setChecked(true);
                }
                if(jouetEtat){
                    jouet.setChecked(true);
                }
                if(jeuxVideoEtat){
                    jeuxVideo.setChecked(true);
                }
                if(plantesEtat){
                    plantes.setChecked(true);
                }
            }
        });

        return result;
    }


    public void reagit(int valeur){
        int exPos = positionCourante;
        if(valeur == JAIME) {
            System.out.println("position : \n " + positionCourante);
            viewPager.setCurrentItem(positionCourante-1);
            adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.like, "Autre produit", "Description du nouveau produit"), exPos);
            adapteur.removeFragment(exPos+1);

        }else if(valeur == JAIMEPAS){
            System.out.println("position : \n " + positionCourante);

            viewPager.setCurrentItem(positionCourante-1);
            adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.dislike, "Autre produit", "Description du nouveau produit"), exPos);
            adapteur.removeFragment(exPos+1);positionCourante--;

        }else{

            System.out.println("position : \n " + positionCourante);

            viewPager.setCurrentItem(positionCourante-1);
            adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.ratporc, "Rat Porc", "Description du nouveau produit"), exPos);
            adapteur.removeFragment(exPos+1);

        }
    }

    private void ajouterProduit(int num){
        switch(num%3){
            case 0 :
                adapteur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Nouveau produit " + num, "Description du nouveau produit"));
                break;

            case 1 :
                adapteur.addFragment(AfficherProduit.newInstance(R.drawable.two, "Nouveau produit " + num, "Description du nouveau produit"));
                break;

            case 2 :
                adapteur.addFragment(AfficherProduit.newInstance(R.drawable.three, "Nouveau produit " + num, "Description du nouveau produit"));
                break;
        }
        //adapteur.addFragment(AfficherProduit.newInstance(R.drawable.one, "Nouveau produit " + num, "Description du nouveau produit"));
    }

    private void ajouterProduitA(int num, int position){
        adapteur.addFragmentAt(AfficherProduit.newInstance(R.drawable.one, "Nouveau produit " + num, "Description du nouveau produit"), position);
    }

    private void afficherPopup() {
        // Créer la vue de la pop-up
        View popupView = getLayoutInflater().inflate(R.layout.popup_resources, null);

        if(popupView != null) {

            // Créer la pop-up
            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
            );

            // Afficher la pop-up au centre de l'écran
            popupWindow.showAtLocation(getActivity().getWindow().getDecorView().getRootView(), Gravity.CENTER, 0, 0);

            // Récupérer les cases à cocher de la pop-up
            informatique = popupView.findViewById(R.id.checkboxInformatique);
            domotique = popupView.findViewById(R.id.checkboxDomotique);
            electromenager = popupView.findViewById(R.id.checkboxElectromenager);
            jouet = popupView.findViewById(R.id.checkboxJouet);
            jeuxVideo = popupView.findViewById(R.id.checkboxJeuxVideo);
            plantes = popupView.findViewById(R.id.checkboxPlantes);

            // Écouter le clic sur le bouton de validation de la pop-up
            Button validerButton = popupView.findViewById(R.id.valider_button);
            validerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Récupérer les états des cases à cocher
                    informatiqueEtat = informatique.isChecked();
                    domotiqueEtat = domotique.isChecked();
                    electromenagerEtat = electromenager.isChecked();
                    jouetEtat = jouet.isChecked();
                    jeuxVideoEtat = jeuxVideo.isChecked();
                    plantesEtat = plantes.isChecked();

                    // Fermer la pop-up
                    popupWindow.dismiss();
                }
            });
        }
    }
}