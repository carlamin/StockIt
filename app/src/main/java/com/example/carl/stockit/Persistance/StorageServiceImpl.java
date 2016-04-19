package com.example.carl.stockit.Persistance;

import android.content.Context;

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

    public  void init(){
        this.listeProduit = new ArrayList<Produit>();
    }
    @Override
    public List<Produit> store(Context context, List<Produit> produits) {
        clear(context);
        listeProduit = produits;
        return restore(context);
    }

    @Override
    public List<Produit> restore(Context context) {

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
}
