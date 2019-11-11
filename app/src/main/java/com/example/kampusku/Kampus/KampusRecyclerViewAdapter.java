package com.example.kampusku.Kampus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kampusku.R;

import java.util.List;

public class KampusRecyclerViewAdapter extends RecyclerView.Adapter<KampusRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<ResultKampus> results;

    public KampusRecyclerViewAdapter(Context context,List<ResultKampus> results) {
        this.context = context;
        this.results = results;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_univ, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultKampus result = results.get(position);
        holder.textViewKategori.setText(result.getKampus());
        holder.textViewAlamat.setText(result.getAlamat());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewKategori;
        TextView textViewAlamat;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewKategori = itemView.findViewById(R.id.kampus);
            textViewAlamat = itemView.findViewById(R.id.alamat);

        }
    }
}
