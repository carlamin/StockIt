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

import com.example.carl.stockit.Adapter.ListLieuxStockageAdaper;
import com.example.carl.stockit.Data.LieuStockage;

import java.util.List;

public class LieuxStockageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listViewLieuxStockage;
    private ListLieuxStockageAdaper adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieux_stockage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent addIntent = new Intent(LieuxStockageActivity.this, AddLieuxStockageActivity.class);
                //startActivity(addIntent);
            }
        });
        listViewLieuxStockage = (ListView) findViewById(R.id.content_main_listView_lieux_de_stockage_contents);
       // adapter = new ListLieuxStockageAdaper(this,R.layout.listview_lieux_stockage);
       // listViewLieuxStockage.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        initLeftNav();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    private void initLeftNav(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        List<LieuStockage> lieuxStockages = ((MyApplication)getApplication()).getStorageService().restoreLieuxStockage(this);

        Intent home = new Intent(this,MainActivity.class);
        menu.getItem(0).setIntent(home);
        final SubMenu subMenuLieuStockage = menu.addSubMenu("Produits");


        for (LieuStockage lieuStockage : lieuxStockages) {
            MenuItem menuItem = subMenuLieuStockage.add(lieuStockage.getNomLieu());
            menuItem.setIcon(Drawable.createFromPath(lieuStockage.getImage()));
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("id", lieuStockage.getId());
            menuItem.setIntent(intent);
        }

        Intent LieuIntent = new Intent(this,LieuxStockageActivity.class);
        menu.add("Lieux de stockage").setIntent(LieuIntent);



        final SubMenu subMenu = menu.addSubMenu("Settings");
        for (int i = 0; i < 2; i++) {
            subMenu.add("SubMenu Item " + (i + 1));
        }

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
        getMenuInflater().inflate(R.menu.lieux_stockage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_clear) {
            List<LieuStockage> lieuStockageList = (List<LieuStockage>) ((MyApplication) getApplication()).getStorageService().clearLieuStockage(this);
            updateAdapter(lieuStockageList);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = item.getIntent();
        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        finish();
        return true;
    }
    protected void onResume() {
        super.onResume();
        List<LieuStockage> listLieuxStockge = (List<LieuStockage>) ((MyApplication) getApplication()).getStorageService().restoreLieuxStockage(this);
        updateAdapter(listLieuxStockge);
    }
    protected void updateAdapter(List<LieuStockage> produitList){
        //adapter.clear();
        //adapter.addAll(produitList);
        //adapter.notifyDataSetChanged();
    }
}
