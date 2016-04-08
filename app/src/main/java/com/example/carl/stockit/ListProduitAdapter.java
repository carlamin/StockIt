package com.example.carl.stockit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.carl.stockit.Data.Produit;

import java.util.List;

/**
 * Created by carl on 02/04/16.
 */
public class ListProduitAdapter extends ArrayAdapter<Produit> {

    public ListProduitAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListProduitAdapter(Context context, int resource, List<Produit> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listview_produits, null);
        }

        final Produit p = getItem(position);

        if (p != null) {
            TextView textView_nomP = (TextView) v.findViewById(R.id.textView_nomProduit);
            final EditText editText_qtiteP = (EditText) v.findViewById(R.id.editText_stockProduit);


            if (textView_nomP != null) {
                textView_nomP.setText(p.getNom());
            }

            if (editText_qtiteP != null) {

                editText_qtiteP.setHint(String.valueOf(p.getQuantite()));
            }

            Button button_ConsommerP = (Button) v.findViewById(R.id.button_ConsommerProduit);
            Button button_AjouterP = (Button) v.findViewById(R.id.button_AjouterProduit);

            editText_qtiteP.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    int q;
                    if (!hasFocus) {
                        // code to execute when EditText loses focus
                        if (!editText_qtiteP.getText().toString().trim().isEmpty()) {
                            q = Integer.parseInt(editText_qtiteP.getText().toString());
                            p.setQuantite(q);
                            notifyDataSetChanged();

                        }
                    }
                }
            });

            button_AjouterP.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    p.ajouter(1);
                    notifyDataSetChanged();

                }
            });
            button_ConsommerP.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    p.consommer(1);
                    notifyDataSetChanged();

                }
            });
            final ImageButton button_settings_produit = (ImageButton) v.findViewById(R.id.imageButton_settings_produit);
            //button_settings_produit.setOnClickListener();


        }
        return v;
    }
}



