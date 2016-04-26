package com.example.carl.stockit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carl.stockit.Adapter.ListReferenceAdapter;
import com.example.carl.stockit.Data.Reference;

import java.util.List;

public class ViewReferenceActivity extends AppCompatActivity{

    private ListView listViewReferences;
    private ListReferenceAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reference);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        InitNav initNav = new InitNav(this);
        initNav.initleftnav();

        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabAjoutReference);
        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent addIntent = new Intent(ViewReferenceActivity.this, AddReferenceActivity.class);
            startActivity(addIntent);
            }
        });

        listViewReferences = (ListView) findViewById(R.id.content_main_listView_References);

        adapter = new ListReferenceAdapter(this, this, R.layout.listview_reference);
        listViewReferences.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }

    protected void onResume() {
        super.onResume();
        List<Reference> listReference = (List<Reference>) ((MyApplication) getApplication()).getStorageService().restoreReference(this);
        updateAdapter(listReference);
    }


    protected void updateAdapter(List<Reference> referenceList) {
        adapter.clear();
        adapter.addAll(referenceList);
        adapter.notifyDataSetChanged();
    }




}