package com.digitalhouse.integracionservicioswebconroom_monroe.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.digitalhouse.integracionservicioswebconroom_monroe.R;
import com.digitalhouse.integracionservicioswebconroom_monroe.model.Producto;

import java.util.List;

public class ProductoRVAdapter extends RecyclerView.Adapter {

        private List<Producto> productoList;

        public ProductoRVAdapter(List<Producto> productoList) {
            this.productoList = productoList;
        }

        public void actualizarLista(List<Producto> productoList){
            this.productoList = productoList;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View vistaInflada = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_producto, parent, false);
            ProductoViewHolder productoViewHolder = new ProductoViewHolder(vistaInflada);
            return productoViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Producto producto = productoList.get(position);
            ProductoViewHolder productoViewHolder = (ProductoViewHolder) holder;
            productoViewHolder.bindProducto(producto);
        }

        @Override
        public int getItemCount() {
            return productoList.size();
        }

        public class ProductoViewHolder extends RecyclerView.ViewHolder {

            private ImageView imageView;
            private TextView textViewProducto;
            private TextView textViewPrecio;

            public ProductoViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageViewProducto);
                textViewProducto = itemView.findViewById(R.id.textViewTituloProcuto);
                textViewPrecio = itemView.findViewById(R.id.textViewPrecioProducto);
            }

            public void bindProducto(Producto unProducto){
                Glide
                        .with(itemView)
                        .load(unProducto.getThumbnail())
                        .into(imageView);

                textViewProducto.setText(unProducto.getTitle());

                textViewPrecio.setText("$ "+unProducto.getPrice());
            }
        }
    }

