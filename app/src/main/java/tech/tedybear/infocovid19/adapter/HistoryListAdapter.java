package tech.tedybear.infocovid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tech.tedybear.infocovid19.R;
import tech.tedybear.infocovid19.model.RiwayatModel;

/*
 * Created by Mochammad Tedy Fazrin on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {

    private ArrayList<RiwayatModel> riwayatModels = new ArrayList<>();
    private Context context;

    public HistoryListAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<RiwayatModel> getRiwayatModels() {
        return riwayatModels;
    }

    public void setRiwayatModels(ArrayList<RiwayatModel> items) {
        if (riwayatModels != null) {
            if (riwayatModels.size() > 0) {
                riwayatModels.clear();
            }
            riwayatModels.addAll(items);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lastUpdateDate.setText(riwayatModels.get(position).getLastUpdate());
        holder.tvConfirmed.setText(riwayatModels.get(position).getConfirmed());
        holder.tvRecovered.setText(riwayatModels.get(position).getRecovered());
        holder.tvDeath.setText(riwayatModels.get(position).getDeaths());
        holder.tvListCountry.setText(context.getResources().getString(R.string.country) + " " + riwayatModels.get(position).getCountryRegion());
    }

    @Override
    public int getItemCount() {
        return riwayatModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lastUpdateDate;
        TextView tvConfirmed;
        TextView tvRecovered;
        TextView tvDeath;
        TextView tvListCountry;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            lastUpdateDate = itemView.findViewById(R.id.tvListLastUpdate);
            tvConfirmed = itemView.findViewById(R.id.tvListConfirmed);
            tvRecovered = itemView.findViewById(R.id.tvListRecovered);
            tvDeath = itemView.findViewById(R.id.tvListDeath);
            tvListCountry = itemView.findViewById(R.id.tvListCountry);
        }
    }
}
