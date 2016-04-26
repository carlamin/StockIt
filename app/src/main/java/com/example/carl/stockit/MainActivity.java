package com.example.carl.stockit;

import android.content.Intent;
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
import android.view.View;
import android.widget.ListView;

import com.example.carl.stockit.Adapter.ListProduitAdapter;
import com.example.carl.stockit.Data.Produit;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProduits;
    private ListProduitAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity.this, AddProduitActivity.class);
                startActivity(addIntent);
            }
        });
    listViewProduits = (ListView) findViewById(R.id.content_main_listView_produitcontents);
        String filter = (String) getIntent().getSerializableExtra("filter");
        adapter = new ListProduitAdapter(this,this,R.layout.listview_produits,filter);
        listViewProduits.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        toggle.syncState();

        /* TEST navigateur */
        InitNav initNav = new InitNav(this);
        initNav.initleftnav();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(initNav);

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
            List<Produit> produitList = (List<Produit>) ((MyApplication) getApplication()).getStorageService().clearProduit(this);
            updateAdapter(produitList);
            return true;
        }

        return super.onOptionsItemSelected(item);
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
