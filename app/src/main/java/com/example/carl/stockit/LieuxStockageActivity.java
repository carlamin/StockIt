package com.example.carl.stockit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.carl.stockit.Adapter.ListLieuxStockageAdapter;
import com.example.carl.stockit.Data.LieuStockage;

import java.util.List;

public class LieuxStockageActivity extends AppCompatActivity {
    private ListView listViewLieuxStockage;
    private ListLieuxStockageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieux_stockage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final InitNav initNav = new InitNav(LieuxStockageActivity.this);
        initNav.initleftnav();

        FloatingActionButton fabL = (FloatingActionButton) findViewById(R.id.fabLieuxStockage);
        fabL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addLIntent = new Intent(LieuxStockageActivity.this, AddLieuxStockageActivity.class);
                startActivity(addLIntent);

            }
        });
        listViewLieuxStockage = (ListView) findViewById(R.id.content_main_listView_lieux_de_stockage_contents);
        adapter = new ListLieuxStockageAdapter(this, this, R.layout.listview_lieux_stockage);
        listViewLieuxStockage.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
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


    protected void onResume() {
        super.onResume();
        List<LieuStockage> listLieuxStockge = (List<LieuStockage>) ((MyApplication) getApplication()).getStorageService().restoreLieuxStockage(this);
        updateAdapter(listLieuxStockge);
    }

    protected void updateAdapter(List<LieuStockage> produitList) {
        adapter.clear();
        adapter.addAll(produitList);
        adapter.notifyDataSetChanged();
    }
}
