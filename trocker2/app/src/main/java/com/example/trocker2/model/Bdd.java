package com.example.trocker2.model;

import java.util.ArrayList;
import java.util.List;

import com.example.trocker2.CustomAdapter;
import com.example.trocker2.R;
import com.example.trocker2.model.Compte;

public class Bdd {

    private static List<Compte> listeCompte = new ArrayList<>();
    private static Compte actif = null;
    private static boolean init = false;

    private static List<Produit> listeProduit = new ArrayList<>();

    public static List<Compte> getListeCompte(){
        return listeCompte;
    }

    public static void initCompte(){
        if(!init) {
            listeCompte.add(new Compte("Lemoult", "Nicolas", "", "nicolas.lemoult@gmail.com", "a12345", "France", "Le Mans", "10 rue nationale", "", "72100", 1));
            listeCompte.add(new Compte("Garcon", "Pierre", "", "pierre.garcon@gmail.com", "a12345", "France", "Le Mans", "10 rue nationale", "", "72100", 5));
            listeCompte.add(new Compte("Garcon", "Pierre", "", "a", "a", "France", "Le Mans", "10 rue nationale", "", "72100", 3));
            Bdd.init = true;
        }
    }

    public static void chargerListProduit(){
        Produit p1 = new Produit();
        Produit p2 = new Produit();
        Produit p3 = new Produit();
        Produit p4 = new Produit();
        Produit p5 = new Produit();

        p1.setId_produit(R.drawable.chaise);
        p2.setId_produit(R.drawable.pc);
        p3.setId_produit(R.drawable.gaz);
        p4.setId_produit(R.drawable.four);
        p5.setId_produit(R.drawable.trousse);

        p1.setNom_produit("Chaise simple");
        p2.setNom_produit("PC gamer");
        p3.setNom_produit("Gazinère portable");
        p4.setNom_produit("Four");
        p5.setNom_produit("Trousse");


        p1.setDescription_produit("Une chaise simple, pratique et confortable");
        p2.setDescription_produit("PC gamer RTX4070");
        p3.setDescription_produit("Gazinière pratique");
        p4.setDescription_produit("Four incroyable, vous n'allez pas en croie vos yeux");
        p5.setDescription_produit("une trousse");


        // Ajout de plusieurs items à la liste
        listeProduit.add(p1);
        listeProduit.add(p2);
        listeProduit.add(p3);
        listeProduit.add(p4);
        listeProduit.add(p5);

    }

    public static List<Produit> getListProduits(){
        return listeProduit;
    }

    public static void addProduits(Produit p, CustomAdapter adapteur){
        listeProduit.add(0,p);
        adapteur.maj();
    }

    public static void addCompte(Compte c){
        listeCompte.add(c);
    }

    public static Compte getActif(){
        return actif;
    }

    public static void setActif(Compte c){
        actif = c;
    }

    public static void deleteCompte(){
        listeCompte.remove(actif);
    }

}
