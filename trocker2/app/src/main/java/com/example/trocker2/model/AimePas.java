package com.example.trocker2.model;

public class AimePas {
    private Compte compte_source;
    private Compte compte_cible;
    private Produit produit;

    public Compte getCompte_source() {
        return compte_source;
    }

    public void setCompte_source(Compte compte_source) {
        this.compte_source = compte_source;
    }

    public Compte getCompte_cible() {
        return compte_cible;
    }

    public void setCompte_cible(Compte compte_cible) {
        this.compte_cible = compte_cible;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
