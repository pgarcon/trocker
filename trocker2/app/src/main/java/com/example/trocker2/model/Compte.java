package com.example.trocker2.model;

import java.sql.Date;

public class Compte {
    private int id_compte;
    private String nom;
    private String prenom;
    private String date;
    private String adresse_mail;
    private String mot_de_passe;
    private int note_compte;
    private String pays;
    private String ville;
    private String adresse;
    private String complement_adresse;
    private String code_postale;

    public Compte(){}
    public Compte(String nom, String prenom, String date, String mail, String mdp, String pays, String ville, String adresse, String complementAdress, String codePostal, int note){
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.adresse_mail = mail;
        this.code_postale = codePostal;
        this.mot_de_passe = mdp;
        this.pays = pays;
        this.ville = ville;
        this.adresse = adresse;
        this.complement_adresse = complementAdress;

        this.note_compte = note;
    }



    /*Getter and setter*/

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public int getNote_compte() {
        return note_compte;
    }

    public void setNote_compte(int note_compte) {
        this.note_compte = note_compte;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getComplement_adresse() {
        return complement_adresse;
    }

    public void setComplement_adresse(String complement_adresse) {
        this.complement_adresse = complement_adresse;
    }

    public String getCode_postale() {
        return code_postale;
    }

    public void setCode_postale(String code_postale) {
        this.code_postale = code_postale;
    }

    /*End getter and setter*/
}
