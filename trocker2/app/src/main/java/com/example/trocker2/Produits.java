package com.example.trocker2;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.Manifest;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trocker2.model.Bdd;
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

    private View result;
    private static final int REQUEST_CAMERA_PERMISSION = 200;

    private Produit p;

    static final int REQUEST_IMAGE_CAPTURE = 200;

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
        Bdd.chargerListProduit();
        // Création de l'adaptateur
        adapter = new CustomAdapter(getActivity(), Bdd.getListProduits());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 3 - Get layout of PageFragment
        result = inflater.inflate(R.layout.fragment_produits, container, false);

        listView = result.findViewById(R.id.listViewProd);

        // Définition de l'adaptateur pour la ListView
        listView.setAdapter(adapter);

        Button button = result.findViewById(R.id.ajouterProduit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afficherPopup();
            }
        });

        return result;
    }


    private void afficherPopup() {
        // Créer la vue de la pop-up
        View popupView = getLayoutInflater().inflate(R.layout.popup_ajouter_produit, null);
        p = new Produit();

        if (popupView != null) {

            // Créer la pop-up
            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
            );

            popupWindow.setWidth(1000);
            popupWindow.setHeight(1400);

            popupWindow.setFocusable(true);

            //popupWindow.showAtLocation(getActivity().getWindow().getDecorView().getRootView(), Gravity.CENTER, 0, 0);


            // Afficher la popup en haut au centre de l'écran
            Button boutonAffichagePopup = result.findViewById(R.id.ajouterProduit);
            Button ajouterImage = popupView.findViewById(R.id.ajouterImage);

            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
            popupWindow.showAtLocation(popupView, Gravity.TOP | Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 200);

            popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

            popupWindow.showAsDropDown(boutonAffichagePopup);

            // Rendre les EditText de la popup modifiables
            EditText editTextTitre = popupView.findViewById(R.id.editTextTitre);
            editTextTitre.setFocusableInTouchMode(true);
            editTextTitre.requestFocus();

            EditText editTextDescription = popupView.findViewById(R.id.editTextDescription);
            editTextDescription.setFocusableInTouchMode(true);

            // Écouter le clic sur le bouton de validation de la pop-up
            Button validerButton = popupView.findViewById(R.id.validerProduit);

            validerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Récupérer les informations
                    p.setDescription_produit(editTextDescription.getText().toString());
                    p.setNom_produit(editTextTitre.getText().toString());
                    p.setId_produit(R.drawable.person);

                    System.out.println("\nNom produit ajouté : "+ p.getNom_produit() + "\n");


                    Bdd.addProduits(p, adapter);
                    // Fermer la pop-up
                    popupWindow.dismiss();
                }
            });

            ajouterImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ajouterImage();
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (requestCode == REQUEST_CAMERA_PERMISSION) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Si l'utilisateur a accordé la permission, ouvre la caméra
                    openCamera();
                    p.setId_produit(R.drawable.handshake_fill);
                } else {
                    // Si l'utilisateur a refusé la permission, affiche un message d'erreur
                    Toast.makeText(getContext(), "Acces Camera refusé", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA_PERMISSION);
    }

    private void ajouterImage(){
        System.out.println("image ajout accès");
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        }else{
            openCamera();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("image accès");

        System.out.println("\nrequest code : " + requestCode + "\nREQUEST_IMAGE_CAPTURE" + REQUEST_IMAGE_CAPTURE + "\nresultCode" + resultCode + "\nRESULT_OK" + RESULT_OK + "\n");

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            System.out.println("image accès succès");
            // L'image a été capturée avec succès
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            p.setImage(imageBitmap);
        }
    }
}