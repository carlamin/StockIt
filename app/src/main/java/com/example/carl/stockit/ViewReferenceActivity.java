package com.example.carl.stockit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ViewReferenceActivity extends AppCompatActivity{

    private ListView listViewReferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reference);




        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabAjoutReference);


        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });









    }
}