package com.josh.android.nba_api;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    HashMap<String,Game> gameMap = new HashMap<String, Game>();
    HashMap<String,LineScore> scoreMap;
    String [] keys;//String array holding keys, enables me to get position for recyclerview from array index
    private OnGameListener mOnGameListener;


    public MyAdapter(HashMap<String,Game> mGameMap, HashMap<String,LineScore> mScoreMap, OnGameListener onGameListener){
        scoreMap=mScoreMap;
        gameMap=mGameMap;
        keys  = new String[mGameMap.size()];
        mGameMap.keySet().toArray(keys);
        this.mOnGameListener = onGameListener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView mCardView;
        public TextView mHomeTeam;
        public TextView mAwayTeam;
        public TextView mHomePoints;
        public TextView mAwayPoints;
        OnGameListener onGameListener;


        public  MyViewHolder(View v, OnGameListener onGameListener){
            super(v);
            mCardView = v.findViewById(R.id.cardview);
            mHomeTeam = v.findViewById(R.id.home_Team);
            mAwayTeam = v.findViewById(R.id.away_Team);
            mHomePoints = v.findViewById(R.id.points_home);
            mAwayPoints = v.findViewById(R.id.points_away);
            this.onGameListener=onGameListener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onGameListener.onGameClick(keys[getAdapterPosition()]);
        }
    }

    public interface OnGameListener{
        void onGameClick(String position);
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view,parent,false);
        MyViewHolder vh = new MyViewHolder(view,mOnGameListener);
        return vh;
    }
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.mHomeTeam.setText(scoreMap.get(gameMap.get(keys[position]).getHOME_TEAM_ID()).getTEAM_CITY_NAME());
        holder.mAwayTeam.setText(scoreMap.get(gameMap.get(keys[position]).getVISITOR_TEAM_ID()).getTEAM_CITY_NAME());
        holder.mHomePoints.setText(scoreMap.get(gameMap.get(keys[position]).getHOME_TEAM_ID()).getPTS());
        holder.mAwayPoints.setText(scoreMap.get(gameMap.get(keys[position]).getVISITOR_TEAM_ID()).getPTS());

    }
    public int getItemCount(){
        return gameMap.size();
    }


}
