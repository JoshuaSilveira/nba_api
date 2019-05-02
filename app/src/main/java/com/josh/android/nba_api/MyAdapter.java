package com.josh.android.nba_api;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private HashMap<Integer,Game> gameMap;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTexView;

        public  MyViewHolder(TextView v){
            super(v);
            mTexView = v;
        }
    }

    public MyAdapter(HashMap<Integer,Game> mGameMap){
            gameMap=mGameMap;
    }

    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view,parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.mTexView.setText(gameMap.get(position).getGAMECODE());


    }
    public int getItemCount(){
        return gameMap.size();
    }


}
