package com.example.trocker2.model;

import java.util.ArrayList;
import java.util.List;

import com.example.trocker.model.Compte;

public class Bdd {

    private static List<Compte> listeCompte = new ArrayList<>();
    private static Compte actif = null;
    private static boolean init = false;

    public static List<Compte> getListeCompte(){
        return listeCompte;
    }

    public static void initCompte(){
        if(!init) {
            listeCompte.add(new Compte("Lemoult", "Nicolas", "", "nicolas.lemoult@gmail.com", "a12345", "France", "Le Mans", "10 rue nationale", "", "72100"));
            listeCompte.add(new Compte("Garcon", "Pierre", "", "pierre.garcon@gmail.com", "a12345", "France", "Le Mans", "10 rue nationale", "", "72100"));
            Bdd.init = true;
        }
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
}
