package com.digitalhouse.integracionservicioswebconroom_monroe.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "product")
public class Producto implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private Integer idProducto;

    @ColumnInfo
    private String title;
    @ColumnInfo
    private String thumbnail;
    @ColumnInfo
    private String price;

    public Producto(String title, String thumbnail, String price) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    @Ignore
    public Producto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
