package com.example.sesion08_examen_parcial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FragmentoRegistro extends Fragment {

    EditText editCodigo, editNombre, editStock, editPrecio, editDescrip;
    Spinner spinTalla;
    Button btnRegistrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_registro, container, false);

        editCodigo = view.findViewById(R.id.editTextCodigo);
        editNombre = view.findViewById(R.id.editTextNombre);
        editStock = view.findViewById(R.id.editTextStock);
        editPrecio = view.findViewById(R.id.editTextPrecio);
        editDescrip = view.findViewById(R.id.editTextDescripcion);
        spinTalla = view.findViewById(R.id.spinnerTalla);
        btnRegistrar = view.findViewById(R.id.btnRegistro);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = editCodigo.getText().toString().trim();
                String nombre = editNombre.getText().toString().trim();
                Integer stock = Integer.parseInt(editStock.getText().toString().trim());
                Double precio = Double.parseDouble(editPrecio.getText().toString().trim());
                String talla = spinTalla.getSelectedItem().toString().trim();
                String descripcion = editDescrip.getText().toString().trim();

                Prenda datos = new Prenda(codigo, nombre, stock, precio, talla, descripcion);

                FragmentoLista fragmentoLista = new FragmentoLista();
                Bundle bundle = new Bundle();
                bundle.putSerializable("datosPrenda", datos);
                fragmentoLista.setArguments(bundle);
                FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, fragmentoLista).commit();
            }
        });

        return view;
    }
}