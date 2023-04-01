package com.example.trocker2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trocker2.model.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Produits#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Produits extends Fragment {

    private ListView listView;
    private CustomAdapter adapter;

    private static final String KEY_POSITION="position";
    private int arg;

    public Produits() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Accueil.
     */
    // TODO: Rename and change types and number of parameters
    public static Produits newInstance(int param1) {
        Produits fragment = new Produits();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, param1);



        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arg = getArguments().getInt(KEY_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 3 - Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_produits, container, false);

        listView = result.findViewById(R.id.listViewProd);

        // Création de l'adaptateur
        adapter = new CustomAdapter(getActivity(), getItems());

        // Définition de l'adaptateur pour la ListView
        listView.setAdapter(adapter);

        return result;
    }

    private List<Produit> getItems() {
        List<Produit> items = new ArrayList<>();


        Produit p1 = new Produit();
        Produit p2 = new Produit();
        Produit p3 = new Produit();
        Produit p4 = new Produit();
        Produit p5 = new Produit();

        p1.setId_produit(R.drawable.one);
        p2.setId_produit(R.drawable.two);
        p3.setId_produit(R.drawable.three);
        p4.setId_produit(R.drawable.four);
        p5.setId_produit(R.drawable.trousse);

        p1.setNom_produit("Mon Produit");
        p2.setNom_produit("Mon Produit");
        p3.setNom_produit("Mon Produit");
        p4.setNom_produit("Mon Produit");
        p5.setNom_produit("ma trousse");


        p1.setDescription_produit("Voici mon produit");
        p2.setDescription_produit("Voici mon produit");
        p3.setDescription_produit("Voici mon produit");
        p4.setDescription_produit("Voici mon produit");
        p5.setDescription_produit("Voici mon produit");


        // Ajout de plusieurs items à la liste
        items.add(p1);
        items.add(p2);
        items.add(p3);
        items.add(p4);
        items.add(p5);

        return items;
    }
}