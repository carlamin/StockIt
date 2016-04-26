package com.example.carl.stockit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.example.carl.stockit.Data.LieuStockage;

import java.util.List;

/**
 * Created by Bzah on 24/04/2016.
 */
public class InitNav implements NavigationView.OnNavigationItemSelectedListener {


    Activity activity;
    public InitNav(Activity activity){
        this.activity = activity;
    }

    public void initleftnav(){
        NavigationView navigationView = (NavigationView) activity.findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();

        List<LieuStockage> lieuxStockages = ((MyApplication)activity.getApplication()).getStorageService().restoreLieuxStockage(activity);

        Intent home = new Intent(activity,MainActivity.class);
        menu.getItem(0).setIntent(home);

        final SubMenu subMenuLieuStockage = menu.addSubMenu("Produits");


        for (LieuStockage lieuStockage : lieuxStockages) {
            MenuItem menuItem = subMenuLieuStockage.add(lieuStockage.getNomLieu());
            menuItem.setIcon(Drawable.createFromPath(lieuStockage.getImage()));
            Intent intent = new Intent(activity, MainActivity.class);
            intent.putExtra("id", lieuStockage.getId());
            menuItem.setIntent(intent);
        }

        Intent LieuIntent = new Intent(activity,LieuxStockageActivity.class);
        menu.add("Lieux de stockage").setIntent(LieuIntent);



        final SubMenu subMenu = menu.addSubMenu("References");

        MenuItem menuItem = subMenu.add("Ajouter une référence");
        Intent intent = new Intent(activity, AddReferenceActivity.class);
        menuItem.setIntent(intent);

        menuItem = subMenu.add("Voir les références");
        intent = new Intent(activity, ViewReferenceActivity.class);
        menuItem.setIntent(intent);

        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = item.getIntent();
        activity.startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
