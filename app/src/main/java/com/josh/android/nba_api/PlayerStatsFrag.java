package com.josh.android.nba_api;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerStatsFrag extends Fragment {
    Button mTeamButton;
    Button mPlayerButton;

    RecyclerView playerRecyclerView;
    private RecyclerView.Adapter playerRecyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playerstats,container,false);
        HashMap<String,PlayerStatsBoxScore> playerStats  = (HashMap<String, PlayerStatsBoxScore>) getArguments().getSerializable("players");

        mTeamButton = (Button)view.findViewById(R.id.team);
        mPlayerButton=(Button)view.findViewById(R.id.player);

        mTeamButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ((GameDetailActivity)getActivity()).setViewPager(0);
            }
        });

        mPlayerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ((GameDetailActivity)getActivity()).setViewPager(1);
            }
        });
        String[] keys = new String[playerStats.size()];
        playerStats.keySet().toArray(keys);

        ArrayList<PlayerStatsBoxScore> team1 = new ArrayList<>();
        ArrayList<PlayerStatsBoxScore> team2 = new ArrayList<>();
        String teamID = playerStats.get(keys[0]).getTEAM_ID();
        for(int i =0;i<=playerStats.size()-1;i++){
            if(playerStats.get(keys[i]).getTEAM_ID().equals(teamID)){
                team1.add(playerStats.get(keys[i]));
            }
            else{
                team2.add(playerStats.get(keys[i]));
            }

        }
        Log.i("dog", team1.get(0).getTEAM_CITY());
        for(int i =0;i<=team1.size()-1;i++) {
            Log.i("dog", team1.get(i).getPLAYER_NAME());
        }
        Log.i("dog", team2.get(0).getTEAM_CITY());
        for(int i =0;i<=team2.size()-1;i++) {
            Log.i("dog", team2.get(i).getPLAYER_NAME());
        }
        playerRecyclerView =(RecyclerView)view.findViewById(R.id.player_recycler_view);

        layoutManager = new LinearLayoutManager(getContext());
        playerRecyclerView.setLayoutManager(layoutManager);

        playerRecyclerAdapter= new PlayerStatsAdapter(team1,team2);
        playerRecyclerView.setAdapter(playerRecyclerAdapter);


        return view;
    }
}
