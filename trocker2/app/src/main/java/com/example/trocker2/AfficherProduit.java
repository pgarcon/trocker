package com.example.trocker2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AfficherProduit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AfficherProduit extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String IMAGE = "image";
    private static final String TITRE = "titre";
    private static final String DESCRIPTION = "description";

    // TODO: Rename and change types of parameters
    private String image;
    private String titre;
    private String description;

    public AfficherProduit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AfficherProduit.
     */
    // TODO: Rename and change types and number of parameters
    public static AfficherProduit newInstance(String image, String titre, String description) {
        AfficherProduit fragment = new AfficherProduit();
        Bundle args = new Bundle();
        args.putString(IMAGE, image);
        args.putString(TITRE, titre);
        args.putString(DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            image = getArguments().getString(IMAGE);
            titre = getArguments().getString(TITRE);
            description = getArguments().getString(DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_afficher_produit, container, false);

        ImageView imageV = result.findViewById(R.id.imageProduit);
        TextView titreV =  result.findViewById(R.id.titreProd);
        TextView descrV =  result.findViewById(R.id.descrProd);


        // 5 - Get data from Bundle (created in method newInstance)
        String image = getArguments().getString(IMAGE, "img");
        String titre = getArguments().getString(TITRE, "titre");
        String descr = getArguments().getString(DESCRIPTION, "description");

        titreV.setText(titre);
        descrV.setText(descr);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment "+ titre);

        return result;

    }
}