package com.digitalhouse.integracionservicioswebconroom_monroe.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.digitalhouse.integracionservicioswebconroom_monroe.R;
import com.digitalhouse.integracionservicioswebconroom_monroe.config.AppDataBase;
import com.digitalhouse.integracionservicioswebconroom_monroe.controller.ProductoController;
import com.digitalhouse.integracionservicioswebconroom_monroe.model.Producto;
import com.digitalhouse.integracionservicioswebconroom_monroe.model.ProductoContainer;
import com.digitalhouse.integracionservicioswebconroom_monroe.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView miRecyclerView;
    private ProductoRVAdapter miRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miRecyclerViewAdapter = new ProductoRVAdapter(new ArrayList<Producto>());

        miRecyclerView = findViewById(R.id.recyclerView);
        miRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        miRecyclerView.setAdapter(miRecyclerViewAdapter);
        miRecyclerView.setHasFixedSize(true);

        ProductoController productoController = new ProductoController(MainActivity.this);

        productoController.obtenerResultadoController(new ResultListener<ProductoContainer>() {
            @Override
            public void finish(ProductoContainer results) {
                List<Producto> listaProductos = results.getResults();
                miRecyclerViewAdapter.actualizarLista(listaProductos);
            }
        });

    }
}
