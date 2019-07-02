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
import android.widget.TextView;

import java.util.Arrays;

public class TeamStatsFrag extends Fragment {
    private RecyclerView mStatView;
    private RecyclerView.Adapter mStatAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Button mTeamButton;
    Button mPlayerButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teamstats,container,false);
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

        TeamStatsBoxScore homeBoxScore = (TeamStatsBoxScore) getArguments().getSerializable("home");
        TeamStatsBoxScore awayBoxScore = (TeamStatsBoxScore) getArguments().getSerializable("away");
        String [] headers = getArguments().getStringArray("headers");
        mStatView = (RecyclerView)view.findViewById(R.id.statView);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mStatView.setLayoutManager(layoutManager);
        mStatAdapter= new StatAdapter(homeBoxScore.sendStatsArrayList(),awayBoxScore.sendStatsArrayList(),headers);
        mStatView.setAdapter(mStatAdapter);
        //Log.i("dog", Arrays.toString(homeBoxScore.sendStatsArrayList()));
       // Log.i("dog", Arrays.toString(awayBoxScore.sendStatsArrayList()));
        return view;
    }
}
