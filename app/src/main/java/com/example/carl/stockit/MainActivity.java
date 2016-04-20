package com.example.carl.stockit;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ListView;

import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.Data.Produit;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listViewProduits;
    private ListProduitAdapter adapter;
    final int AJOUTREFERENCE = 250;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //listProduit = new ArrayList<Produit>();
        ((MyApplication) getApplication()).getStorageService().init();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity.this, AddProduitActivity.class);
                startActivity(addIntent);
            }
        });
listViewProduits = (ListView) findViewById(R.id.content_main_listView_produitcontents);
        adapter = new ListProduitAdapter(this,R.layout.listview_produits);
        listViewProduits.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        initLeftNav();


    }

    private void initLeftNav(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        List<LieuStockage> lieuxStockages = ((MyApplication)getApplication()).getStorageService().findLieu();
        final SubMenu subMenuLieuStockage = menu.addSubMenu("Lieux de stockage");

        for (LieuStockage lieuStockage : lieuxStockages) {
            MenuItem menuItem = subMenuLieuStockage.add(lieuStockage.getNomLieu());
            menuItem.setIcon(Drawable.createFromPath(lieuStockage.getImage()));
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("id", lieuStockage.getId()  );
            menuItem.setIntent(intent);
        }



        final SubMenu subMenu = menu.addSubMenu("Settings");

        MenuItem menuItem = subMenu.add(0,25,Menu.NONE,"Ajouter une référence");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id",AJOUTREFERENCE);
        menuItem.setIntent(intent);

/*
        for (int i = 0; i < 2; i++) {
            subMenu.add("SubMenu Item " + (i + 1));

        }
*/
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear) {
            List<Produit> produitList = (List<Produit>) ((MyApplication) getApplication()).getStorageService().clear(this);
            updateAdapter(produitList);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = (int) item.getIntent().getSerializableExtra("id");

       if(id == AJOUTREFERENCE){
           /* LANCER AJOUT REFERENCE */
           System.out.println("SWAG!");
           Intent addIntent = new Intent(MainActivity.this, AddReferenceActivity.class);
           startActivity(addIntent);

       }else if(id ==2 ){}else if(id ==3){}


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void onResume() {
        super.onResume();
       List<Produit> listProduit = (List<Produit>) ((MyApplication) getApplication()).getStorageService().restoreProduits(this);
        updateAdapter(listProduit);
    }
    protected void updateAdapter(List<Produit> produitList){
        adapter.clear();
        adapter.addAll(produitList);
        adapter.notifyDataSetChanged();
    }
}
