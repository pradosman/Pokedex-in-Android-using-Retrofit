package com.example.davidprados.pokedex.adaptadores;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.davidprados.pokedex.R;
import com.example.davidprados.pokedex.pojo.Pokemon;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by David Prados on 26/11/2017.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> datos;
    private Context context;

    public PokemonAdapter(Context context){
        this.context = context;
        datos = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.ViewHolder holder, int position) {
        Pokemon p = datos.get(position);
        holder.nombreTextView.setText(p.getName().toUpperCase());
        holder.numeroTextView.setText("#"+p.getNumber());

        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void addListaPokemon(ArrayList<Pokemon> listaPokemon) {
        datos.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoImageView;
        private TextView nombreTextView;
        private TextView numeroTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.idImagen);
            nombreTextView = (TextView) itemView.findViewById(R.id.idNombre);
            numeroTextView = (TextView) itemView.findViewById(R.id.idNumero);
        }
    }
}
