package com.example.sesion08_examen_parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtCodigo, txtNombre, txtStock,txtPrecio, txtTalla, txtDescrip;
    private Button btnCarrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txtCodigo = findViewById(R.id.textViewCodigo);
        txtNombre = findViewById(R.id.textViewNombre);
        txtStock = findViewById(R.id.textViewStock);
        txtPrecio = findViewById(R.id.textViewPrecio);
        txtTalla = findViewById(R.id.textViewTalla);
        txtDescrip = findViewById(R.id.textViewDescripcion);
        btnCarrito = findViewById(R.id.buttonCarrito);

        Prenda seleccionado = (Prenda) getIntent().getSerializableExtra("detallePrenda");

        txtCodigo.setText(seleccionado.getCodigo());
        txtNombre.setText(seleccionado.getNombre());
        txtStock.setText(seleccionado.getStock().toString() + " Unidades disponibles");
        txtPrecio.setText("S/. " + seleccionado.getPrecio().toString());
        txtTalla.setText(seleccionado.getTalla());
        txtDescrip.setText(seleccionado.getDescripcion());


    }

    public void eventoRegresar(View view) {
        Intent intent = new Intent(view.getContext(), FragmentoLista.class);
        startActivity(intent);
    }
}