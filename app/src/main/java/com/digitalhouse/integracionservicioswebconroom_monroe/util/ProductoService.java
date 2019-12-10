package com.digitalhouse.integracionservicioswebconroom_monroe.util;

import com.digitalhouse.integracionservicioswebconroom_monroe.model.ProductoContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductoService {

    @GET("search")
    Call<ProductoContainer> getCallService(@Query("q") String productoBuscado);

}
