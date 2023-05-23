package com.example.sesion08_examen_parcial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Prenda> {

    private final View context;
    private final List<Prenda> listaPrendas;

    public ListAdapter(View context, int resource, List<Prenda> listaPrendas) {
        super(context.getContext(), resource, listaPrendas);
        this.context = context;
        this.listaPrendas = listaPrendas;
    }

    public int getCount() {
        return listaPrendas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView txtNom = rowView.findViewById(R.id.txt_nombre);
        TextView txtPre = rowView.findViewById(R.id.txt_precio);
        txtNom.setText(String.format("%s", listaPrendas.get(position).getNombre()));
        txtPre.setText(String.format("%s", "S/. "+listaPrendas.get(position).getPrecio()));

        return rowView;
    }
}