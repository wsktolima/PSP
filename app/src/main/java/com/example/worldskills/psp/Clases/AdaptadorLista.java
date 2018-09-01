package com.example.worldskills.psp.Clases;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.psp.R;

import java.util.ArrayList;


/**
 * Clase que ayuda a Generar un Adaptador para cada elemento del Recycler View
 */
public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ListaViewHolder> implements View.OnClickListener {

    ArrayList<Proyecto> proyectos;
    View.OnClickListener listener;

    public AdaptadorLista(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, null);

        RecyclerView.LayoutParams p = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(p);

        layout.setOnClickListener(this);
        return new ListaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        holder.tituloProyecto.setText(proyectos.get(position).getNombreProyecto());
    }

    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder {

        TextView tituloProyecto;

        public ListaViewHolder(View itemView) {
            super(itemView);

            tituloProyecto = itemView.findViewById(R.id.nom_proyecto);

        }
    }
}
