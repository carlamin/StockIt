package com.example.carl.stockit.Persistance;

import android.content.Context;

import com.example.carl.stockit.Data.Produit;

import java.util.Collections;
import java.util.List;

/**
 * Created by carl on 30/03/16.
 */
public class StorageServiceImpl implements StorageService {
    private List<Produit> listeProduit ;
    @Override
    public List<String> store(Context context, List<String> articles) {
        clear(context);

        return null;
    }

    @Override
    public List<Produit> restore(Context context) {
        Collections.sort(listeProduit);
        return  listeProduit;

    }

    @Override
    public List<Produit> clear(Context context) {
        listeProduit.clear();
        return listeProduit;
    }

    @Override
    public void add(Context context, String article,int qtite) {
        Produit p = new Produit(article,qtite);
        listeProduit.add(p);
    }
}
