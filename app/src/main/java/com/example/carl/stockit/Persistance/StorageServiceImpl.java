package com.example.carl.stockit.Persistance;

import android.content.Context;

import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.Data.Produit;
import com.example.carl.stockit.Data.Reference;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by carl on 30/03/16.
 */
public class StorageServiceImpl implements StorageService {
    private List<Produit> listeProduit;
    private List<LieuStockage> listeLieux;
    private List<Reference> listeReference;

    public StorageServiceImpl() {
        this.listeProduit = new ArrayList<Produit>();
        this.listeLieux = new ArrayList<LieuStockage>();
        this.listeReference = new ArrayList<Reference>();
        LieuStockage lieu1 = new LieuStockage(1,"Frigo",30,"Cuisine","","/cuisine");
        LieuStockage lieu2 = new LieuStockage(2,"Armoire",40,"Salon","","/salon");
        LieuStockage lieu3 = new LieuStockage(3,"Four",3,"Cuisine","","/img");
        Reference ref1 = new Reference( "steak", 123, "categorie", "url");
        Reference ref2 = new Reference( "pomme", 123, "categorie", "url");
        this.listeReference.add(ref1);
        this.listeReference.add(ref2);
        this.listeLieux.add(lieu1);
        this.listeLieux.add(lieu2);
        this.listeLieux.add(lieu3);
    }

    public  void init(){
        //this.listeProduit = ;
        //this.listeLieux = ;

    }


    @Override
    public List<Produit> storeProduit(Context context, List<Produit> produits) {
        clearProduit(context);
        listeProduit = produits;
        return restoreProduits(context);
    }

    @Override
    public List<LieuStockage> storeLieuStockage(Context context, List<LieuStockage> listeLieux) {
        clearProduit(context);
        this.listeLieux= listeLieux;
        return restoreLieuxStockage(context);
    }

    @Override
    public List<Produit> restoreProduits(Context context) {

        return  listeProduit;

    }

    @Override
    public List<LieuStockage> restoreLieuxStockage(Context context) {
        return  listeLieux;

    }

    @Override
    public List<Produit> clearProduit(Context context) {
        listeProduit.clear();
        return listeProduit;
    }

    @Override
    public List<LieuStockage> clearLieuStockage(Context context) {
        listeLieux.clear();
        return listeLieux;
    }

    public void addProduit(Context context, String nomP,int qtite,int pDay,int pMonth , int pYear,String nomLieu , String nomRef) {
        Produit p = new Produit();
        p.setNom(nomP);
        p.setQuantite(qtite);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,pDay);
        cal.set(Calendar.MONTH,pMonth);
        cal.set(Calendar.YEAR,pYear);
        Date date = cal.getTime();

        p.setDateExpiration(date);
for(LieuStockage l : listeLieux){
    if(l.getNomLieu().equals(nomLieu)){
        p.setLieuStockage(l);
    }
}
        for(Reference r : listeReference){
            if (r.getNomRef().equals(nomRef)){
                p.setReference(r);
            }
        }
        listeProduit.add(p);
    }

    @Override
    public void modifierProduit(Context context, int position, String nomP, int qtite, int pDay, int pMonth, int pYear,String nomLieu , String nomRef) {
        Produit p = new Produit();
        p.setNom(nomP);
        p.setQuantite(qtite);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,pDay);
        cal.set(Calendar.MONTH,pMonth);
        cal.set(Calendar.YEAR,pYear);
        Date date = cal.getTime();

        p.setDateExpiration(date);
        for(LieuStockage l : listeLieux){
            if(l.getNomLieu().equals(nomLieu)){
                p.setLieuStockage(l);
            }
        }
        for(Reference r : listeReference){
            if (r.getNomRef().equals(nomRef)){
                p.setReference(r);
            }
        }
        listeProduit.set(position,p);
    }

    @Override
    public void addLieuxStockage(Context context, String nomL, int capacite, String localisation) {
        LieuStockage l = new LieuStockage();
        l.setNomLieu(nomL);
        l.setCapacite(capacite);
        l.setLocalisation(localisation);
        listeLieux.add(l);
    }


    @Override
    public void addReference(Context context, String nomReference, int codeBarre, String categorie, String urlPhoto) {
        Reference reference = new Reference();
        reference.setCategorie(categorie);
        reference.setCodeBarre(codeBarre);
        reference.setNomRef(nomReference);
        reference.setURLPhoto(urlPhoto);

        // il faut ensuite ajouter la ref dans la BD
        // la methode d'appel à la BD doit etre dans reference.java
    }

    @Override
    public List<Reference> restoreReference(Context context) {
        return listeReference;
    }
}
