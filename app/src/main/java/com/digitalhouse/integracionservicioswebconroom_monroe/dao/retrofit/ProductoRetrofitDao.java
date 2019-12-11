package com.digitalhouse.integracionservicioswebconroom_monroe.dao.retrofit;

import com.digitalhouse.integracionservicioswebconroom_monroe.model.ProductoContainer;
import com.digitalhouse.integracionservicioswebconroom_monroe.util.ProductoService;
import com.digitalhouse.integracionservicioswebconroom_monroe.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoRetrofitDao {


    private ProductoService productoService;
    private Retrofit retrofit;
    public static final String BASE_URL = "https://api.mercadolibre.com/sites/MLA/";

    public ProductoRetrofitDao() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productoService = retrofit.create(ProductoService.class);
    }

    public void obtenerResultadoDao(final ResultListener<ProductoContainer> escuchadorDelControler){
        Call<ProductoContainer> callProductos = productoService.getCallService("autos");

        callProductos.enqueue(new Callback<ProductoContainer>() {
            @Override
            public void onResponse(Call<ProductoContainer> call, Response<ProductoContainer> response) {
                ProductoContainer productoContainerDeInternet = response.body();
                escuchadorDelControler.finish(productoContainerDeInternet);
            }

            @Override
            public void onFailure(Call<ProductoContainer> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
