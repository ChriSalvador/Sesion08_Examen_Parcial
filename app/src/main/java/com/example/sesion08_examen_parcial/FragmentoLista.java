package com.example.sesion08_examen_parcial;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentoLista extends Fragment {

    private List<Prenda> prendas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_lista, container, false);

        prendas.add(new Prenda("#P01", "Camiseta básica", 20, 40.00,
                "L", "Camisa clásica para todos los hombres."));
        prendas.add(new Prenda("#P02", "Abrigo de lana con cuello de piel sintética",
                35, 499.99, "S", "Prenda elegante y cálida que combina estilo y comodidad."));
        prendas.add(new Prenda("#P03", "Zapatillas deportivas", 16, 399.99,
                "32", "Zapatillas suaves y cómodas para arduas horas deportivas."));
        ListView listView = view.findViewById(R.id.list_view);

        Bundle bundle = getArguments();
        if (bundle == null) {
            ListAdapter adapter = new ListAdapter(view, R.layout.list_item, prendas);
            listView.setAdapter(adapter);
        } else{
            Prenda pre = (Prenda) bundle.getSerializable("datosPrenda");
            prendas.add(new Prenda(pre.getCodigo(), pre.getNombre(), pre.getStock(), pre.getPrecio(), pre.getTalla(), pre.getDescripcion()));
            ListAdapter adapter = new ListAdapter(view, R.layout.list_item, prendas);
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Prenda prendaSeleccionada =(Prenda) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), DetalleActivity.class);
                intent.putExtra("detallePrenda", prendaSeleccionada);
                startActivity(intent);
            }
        });

        return view;
    }

}