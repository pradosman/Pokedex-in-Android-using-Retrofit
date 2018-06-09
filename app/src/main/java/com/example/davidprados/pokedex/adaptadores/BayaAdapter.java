package com.example.davidprados.pokedex.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidprados.pokedex.R;
import com.example.davidprados.pokedex.pojo.Baya;

import java.util.ArrayList;

/**
 * Created by David Prados on 27/11/2017.
 */

public class BayaAdapter extends RecyclerView.Adapter<BayaAdapter.ViewHolder> {

    private ArrayList<Baya> datos;
    private Context context;

    public BayaAdapter(Context context){
        this.context = context;
        datos = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baya, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BayaAdapter.ViewHolder holder, int position) {
        Baya m = datos.get(position);

        holder.nombreTextView.setText(m.getName().toUpperCase());
        holder.numeroTextView.setText("#"+(position+1));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void addListaBayas(ArrayList<Baya> listaBayas) {
        datos.addAll(listaBayas);
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
