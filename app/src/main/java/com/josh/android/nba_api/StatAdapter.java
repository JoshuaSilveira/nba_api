package com.josh.android.nba_api;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class StatAdapter extends RecyclerView.Adapter<StatAdapter.StatViewHolder> {

    ArrayList<String> home;
    ArrayList<String> away;
    String[] headers;

    public StatAdapter(ArrayList<String> mHome, ArrayList<String> mAway,String[] mheaders){
        home = mHome;
        away = mAway;
        headers = mheaders;

    }

    public class StatViewHolder extends RecyclerView.ViewHolder {
        public TextView mHomeStat;
        public TextView mStat;
        public TextView mAwayStat;

        public StatViewHolder(@NonNull View itemView) {
            super(itemView);
            mHomeStat = itemView.findViewById(R.id.homestat);
            mStat=itemView.findViewById(R.id.stat);
            mAwayStat=itemView.findViewById(R.id.awaystat);

        }
    }

    public StatViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teamstatview,parent,false);

        return new StatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatViewHolder statViewHolder, int i) {

        statViewHolder.mHomeStat.setText(home.get(i));
        statViewHolder.mStat.setText(headers[i]);
        statViewHolder.mAwayStat.setText(away.get(i));

    }

    @Override
    public int getItemCount() {
        return home.size();
    }

}
