package com.example.carl.stockit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
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

            Produit p = getItem(position);

            if (p != null) {
                TextView textView_nomP = (TextView) v.findViewById(R.id.textView_nomProduit);
                final TextView textView_qtiteP = (TextView) v.findViewById(R.id.textView_stockProduit);


                if (textView_nomP != null) {
                    textView_nomP.setText(p.getNom());
                }

                if (textView_qtiteP != null) {
                    textView_qtiteP.setText(String.valueOf(p.getQuantite()));
                }
                final int minValue = p.getQuantite();

                final int maxValue = 500;
                NumberPicker numberPicker_modifQtiteP = (NumberPicker) v.findViewById(R.id.numberPicker_ModifierQtiteProduit);
                numberPicker_modifQtiteP.setMinValue(0);
                numberPicker_modifQtiteP.setMaxValue(maxValue);
                numberPicker_modifQtiteP.setWrapSelectorWheel(true);
                numberPicker_modifQtiteP.setFormatter(new NumberPicker.Formatter() {
                    @Override
                    public String format(int index) {
                        return  Integer.toString(index - minValue);
                    }
                });
                if(numberPicker_modifQtiteP.getValue()+minValue != 0){
                    p.setQuantite(p.getQuantite()+numberPicker_modifQtiteP.getValue()+minValue);
                    textView_qtiteP.setText(String.valueOf(p.getQuantite()));
                }


            }

            return v;
        }


    }


