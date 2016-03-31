package com.example.carl.stockit.Persistance;

import android.content.Context;

import java.util.List;

/**
 * Created by carl on 26/03/16.
 */
public interface StorageService {
    /**
     * Enregistre la liste des articles passés en paramètre.
     * @param context contexte de l'activité
     * @param articles liste des articles
     * @return liste des articles sauvegardés par ordre alphabétique
     */
    public List<?> store(Context context, List<String> articles);

    /**
     * Récupère la liste des articles sauvegardés.
     * @param context contexte de l'activité
     * @return liste des articles sauvegardés par ordre alphabétique
     */
    public List<?> restore(Context context);

    /**
     * Vide la liste des articles.
     * @param context contexte de l'activité
     * @return liste des articles vide.
     */
    public List<?> clear(Context context);

    /**
     * Enregistre un nouvel article passé en paramètre.
     * @param context contexte de l'activité
     * @param article article
     */
    public void add(Context context, String article,int qtite);
}
