package com.example.carl.stockit.Data;


import java.io.Serializable;
import java.util.Date;


public class Produit implements Comparable,Serializable{
    private String nom;
   private int quantite;
    private Date dateExpiration;
    private Reference reference;
    private LieuStockage lieuStockage;

    public Produit(String nom, int quantite, Date dateExpiration, Reference reference, LieuStockage lieuStockage) {

        this.nom = nom;
        this.quantite = quantite;
        this.dateExpiration = dateExpiration;
        this.reference = reference;
        this.lieuStockage = lieuStockage;
    }

    public Produit() {

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public LieuStockage getLieuStockage() {
        return lieuStockage;
    }

    public void setLieuStockage(LieuStockage lieuStockage) {
        this.lieuStockage = lieuStockage;
    }

    public void consommer(int q){
        this.quantite = this.quantite - q;
    }

    public void ajouter(int q){
        this.quantite = this.quantite + q;
    }
    public int compareTo(Produit p) {

        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
