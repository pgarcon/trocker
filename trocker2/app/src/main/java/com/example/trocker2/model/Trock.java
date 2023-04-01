package com.example.trocker2.model;

public class Trock {
    private int id_trock;
    private Compte client_un;
    private Compte client_deux;
    private Produit produit_un;
    private Produit produit_deux;
    private boolean est_archive;

    public int getId_trock() {
        return id_trock;
    }

    public void setId_trock(int id_trock) {
        this.id_trock = id_trock;
    }

    public Compte getClient_un() {
        return client_un;
    }

    public void setClient_un(Compte client_un) {
        this.client_un = client_un;
    }

    public Compte getClient_deux() {
        return client_deux;
    }

    public void setClient_deux(Compte client_deux) {
        this.client_deux = client_deux;
    }

    public Produit getProduit_un() {
        return produit_un;
    }

    public void setProduit_un(Produit produit_un) {
        this.produit_un = produit_un;
    }

    public Produit getProduit_deux() {
        return produit_deux;
    }

    public void setProduit_deux(Produit produit_deux) {
        this.produit_deux = produit_deux;
    }

    public boolean isEst_archive() {
        return est_archive;
    }

    public void setEst_archive(boolean est_archive) {
        this.est_archive = est_archive;
    }
}
