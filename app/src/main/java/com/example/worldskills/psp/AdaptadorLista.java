package com.example.worldskills.psp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ListaViewHolder> {

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, null);
        RecyclerView.LayoutParams p = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(p);
        return new ListaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder {
        public ListaViewHolder(View itemView) {
            super(itemView);
        }
    }
}
