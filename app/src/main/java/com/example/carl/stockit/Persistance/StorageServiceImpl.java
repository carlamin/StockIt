package com.example.carl.stockit.Persistance;

import android.content.Context;

import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.Data.Produit;

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

    public  void init(){
        this.listeProduit = new ArrayList<Produit>();
        this.listeLieux = new ArrayList<LieuStockage>();
        LieuStockage lieu1 = new LieuStockage(1,"Frigo",30,"Cuisine","","/cuisine");
        LieuStockage lieu2 = new LieuStockage(2,"Armoire",40,"Salon","","/salon");
        LieuStockage lieu3 = new LieuStockage(3,"Four",3,"Cuisine","","/img");
        this.listeLieux.add(lieu1);
        this.listeLieux.add(lieu2);
        this.listeLieux.add(lieu3);
    }
    @Override
    public List<Produit> store(Context context, List<Produit> produits,List<LieuStockage> listeLieux) {
        clear(context);
        listeProduit = produits;
        this.listeLieux=listeLieux;
        return restoreProduits(context);
    }

    @Override
    public List<Produit> restoreProduits(Context context) {

        return  listeProduit;

    }

    @Override
    public List<Produit> clear(Context context) {
        listeProduit.clear();
        return listeProduit;
    }

    public void addProduit(Context context, String nomP,int qtite,int pDay,int pMonth , int pYear) {
        Produit p = new Produit();
        p.setNom(nomP);
        p.setQuantite(qtite);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,pDay);
        cal.set(Calendar.MONTH,pMonth);
        cal.set(Calendar.YEAR,pYear);
        Date date = cal.getTime();

        p.setDateExpiration(date);

        listeProduit.add(p);
    }

    @Override
    public void modifierProduit(Context context, int position, String nomP, int qtite, int pDay, int pMonth, int pYear) {
        Produit p = new Produit();
        p.setNom(nomP);
        p.setQuantite(qtite);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,pDay);
        cal.set(Calendar.MONTH,pMonth);
        cal.set(Calendar.YEAR,pYear);
        Date date = cal.getTime();

        p.setDateExpiration(date);
        listeProduit.set(position,p);
    }

    @Override
    public List<LieuStockage> findLieu() {




        return this.listeLieux;
    }
}
