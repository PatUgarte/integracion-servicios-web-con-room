package com.digitalhouse.integracionservicioswebconroom_monroe.controller;

import com.digitalhouse.integracionservicioswebconroom_monroe.dao.ProductoDao;
import com.digitalhouse.integracionservicioswebconroom_monroe.model.ProductoContainer;
import com.digitalhouse.integracionservicioswebconroom_monroe.util.ResultListener;

public class ProductoController {

    private ProductoDao productoDao;

    public ProductoController() {
        this.productoDao = new ProductoDao();
    }

    public void obtenerResultadoController(final ResultListener<ProductoContainer> escuchadorDeLaVista){
        productoDao.obtenerResultadoDao(new ResultListener<ProductoContainer>() {
            @Override
            public void finish(ProductoContainer results) {
                escuchadorDeLaVista.finish(results);
            }
        });
    }
}

