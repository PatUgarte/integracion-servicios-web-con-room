package com.digitalhouse.integracionservicioswebconroom_monroe.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.digitalhouse.integracionservicioswebconroom_monroe.dao.room.ProductoRoomDao;
import com.digitalhouse.integracionservicioswebconroom_monroe.model.Producto;

@Database(version = 1,entities = Producto.class)
public abstract class AppDataBase extends RoomDatabase {

    //Exponemos el Dao a partir de la DB
    public abstract ProductoRoomDao productoRoomDao();

    //Singleton
    public static AppDataBase INSTANCE = null;

    public static AppDataBase getInstance(Context context){
        /*Primero pregunto si sigue siendo null, para generar la Database.
        Una vez generada ya no va a volver a entrar en este método porque ya no vale null.
        Esa es la magia del SINGLETON (Patrón de diseño).*/
        if(INSTANCE == null){
            INSTANCE = Room
                    .databaseBuilder(context,
                            AppDataBase.class,
                            "db-productos")
                    .build();
        }

        return INSTANCE;
    }
}
