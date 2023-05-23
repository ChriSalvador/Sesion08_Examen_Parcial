package com.example.sesion08_examen_parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sesion08_examen_parcial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        reemplazarFragmento(new FragmentoRegistro());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.nuevaPrenda:
                    reemplazarFragmento(new FragmentoRegistro());
                    break;
                case R.id.verPrendas:
                    reemplazarFragmento(new FragmentoLista());
                    break;
                    //Otros id de fragments
            }

            return true;
        });
    }

    public void reemplazarFragmento(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor_fragments, fragment);
        fragmentTransaction.commit();
    }

}