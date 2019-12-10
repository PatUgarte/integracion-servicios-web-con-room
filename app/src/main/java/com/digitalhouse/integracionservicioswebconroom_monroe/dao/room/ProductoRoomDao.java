package com.digitalhouse.integracionservicioswebconroom_monroe.dao.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.digitalhouse.integracionservicioswebconroom_monroe.model.Producto;

import java.util.List;

@Dao
public interface ProductoRoomDao {

    @Query("SELECT * FROM product")
    List<Producto> getAllProducts();

    @Insert
    void insertProducts(Producto... productos);

    @Insert
    void insertProducts(List<Producto> productos);

    @Query("DELETE FROM product")
    void deleteAll();

}
