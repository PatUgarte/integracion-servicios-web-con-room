package com.digitalhouse.integracionservicioswebconroom_monroe.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.digitalhouse.integracionservicioswebconroom_monroe.config.AppDataBase;
import com.digitalhouse.integracionservicioswebconroom_monroe.dao.retrofit.ProductoRetrofitDao;
import com.digitalhouse.integracionservicioswebconroom_monroe.dao.room.ProductoRoomDao;
import com.digitalhouse.integracionservicioswebconroom_monroe.model.Producto;
import com.digitalhouse.integracionservicioswebconroom_monroe.model.ProductoContainer;
import com.digitalhouse.integracionservicioswebconroom_monroe.util.ResultListener;

import java.util.List;

public class ProductoController {

    private ProductoRetrofitDao productoRetrofitDao;
    private ProductoRoomDao productoRoomDao;
    private Context context;

    public ProductoController(Context context) {
        this.productoRetrofitDao = new ProductoRetrofitDao();
        this.productoRoomDao = AppDataBase.getInstance(context).productoRoomDao();
        this.context = context;
    }

    public void obtenerResultadoController(final ResultListener<ProductoContainer> escuchadorDeLaVista){

        if(hayInternet(context)){
            productoRetrofitDao.obtenerResultadoDao(new ResultListener<ProductoContainer>() {
                @Override
                public void finish(ProductoContainer results) {

                    //Quiero guardar lo último traido en la DB
                    List<Producto> listaProductosDeInternet = results.getResults();
                    //Limpio la tabla de Productos para volver a cargar lo último traido
                    productoRoomDao.deleteAll();
                    //Inserto la nueva lista de Productos con lo último traido de internet
                    productoRoomDao.insertProducts(listaProductosDeInternet);

                    escuchadorDeLaVista.finish(results);
                }
            });
        } else {
            //Voy a pedir lo último que tenga la DB y se lo voy a pasar a la Vista
            List<Producto> allProducts = productoRoomDao.getAllProducts();
            ProductoContainer productoContainerRoom = new ProductoContainer();
            productoContainerRoom.setResults(allProducts);

            escuchadorDeLaVista.finish(productoContainerRoom);
        }
    }

    public Boolean hayInternet(Context context){

        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
/*

        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        } else {
            return false;
        }

*/
        return isConnected;

    }
}

