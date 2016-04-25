package com.example.carl.stockit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.R;

import java.util.List;

/**
 * Created by carl on 02/04/16.
 */
public class ListLieuxStockageAdapter extends ArrayAdapter<LieuStockage> implements MenuItem.OnMenuItemClickListener{
    private List<LieuStockage> listLieuxStockage;
    Context context;



    public ListLieuxStockageAdapter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi =LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listview_lieux_stockage, null);
        }

        final LieuStockage lieuStockage = getItem(position);

        if (lieuStockage != null) {
            TextView textView_nomL = (TextView) v.findViewById(R.id.textView_nomLieuxStockage);
            TextView textView_capacite = (TextView) v.findViewById(R.id.textView_capaciteStock);


            if (textView_nomL != null) {
                textView_nomL.setText(lieuStockage.getNomLieu());
            }

            if (textView_capacite != null) {

               textView_capacite.setText(String.valueOf(lieuStockage.getCapacite()));
            }





            LinearLayout linearLayoutL = (LinearLayout) v.findViewById(R.id.linearLayout_lieuxStockage);
            final LinearLayout linearLayoutLPF = (LinearLayout) v.findViewById(R.id.linearLayout_lieuxStockagePlusInfo);

            textView_nomL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(linearLayoutLPF.getVisibility() == View.VISIBLE){
                        linearLayoutLPF.setVisibility(View.GONE);
                    }else{
                        linearLayoutLPF.setVisibility(View.VISIBLE);}
                }
            });

            /*v.findViewById(R.id.imageButton_settings_produit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ModifierIntent = new Intent(getContext(), ModifierLieuxStockageActivity.class);
                    ModifierIntent.putExtra("produit", p);
                    ModifierIntent.putExtra("position",position);
                    getContext().startActivity(ModifierIntent);
                }
            });
            final ImageButton imgDeleteProduit = (ImageButton) v.findViewById(R.id.imageButton_deleteProduit);

*/
        }




        return v;
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}




