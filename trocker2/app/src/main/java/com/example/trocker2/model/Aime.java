package com.example.trocker.model;

public class Aime {
    private Compte compte_source;
    private Compte compte_cible;
    private Produit produit;
    private Boolean est_super_like;

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

    public Boolean getEst_super_like() {
        return est_super_like;
    }

    public void setEst_super_like(Boolean est_super_like) {
        this.est_super_like = est_super_like;
    }

}
