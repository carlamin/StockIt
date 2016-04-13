package com.example.carl.stockit.Persistance;

import android.content.Context;

import com.example.carl.stockit.Data.Produit;

import java.util.ArrayList;
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

    @Override
    public void addProduit(Context context, String nomProduit,int qtite) {
        Produit p = new Produit();
        p.setNom(nomProduit);
        p.setQuantite(qtite);

        listeProduit.add(p);
    }
}
