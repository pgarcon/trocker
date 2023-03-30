package com.example.trocker.model;

public class Message {
    private int id_message;
    private Compte Compte_cible;
    private Compte Compte_source;
    private String details;

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public Compte getCompte_cible() {
        return Compte_cible;
    }

    public void setCompte_cible(Compte compte_cible) {
        Compte_cible = compte_cible;
    }

    public Compte getCompte_source() {
        return Compte_source;
    }

    public void setCompte_source(Compte compte_source) {
        Compte_source = compte_source;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
