package com.example.trocker2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.trocker2.model.Produit;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    private Context context;
    private List<Produit> items;

    public CustomAdapter(Context context, List<Produit> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Récupération de l'item à la position donnée
        Produit item = (Produit)getItem(position);

        // Création du layout de l'item
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_produits, parent, false);
        }

        // Récupération des vues du layout de l'item
        TextView titreProduit = convertView.findViewById(R.id.titreProduit);
        TextView descrProduit = convertView.findViewById(R.id.descrProduit);
        ImageView imageView = convertView.findViewById(R.id.imageproduit);

        imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));

        // Mise à jour des vues avec les données de l'item
        titreProduit.setText(item.getNom_produit());
        descrProduit.setText(item.getDescription_produit());
        imageView.setImageResource(item.getId_produit());

        return convertView;
    }
}