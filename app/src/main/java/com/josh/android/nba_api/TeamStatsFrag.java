package com.josh.android.nba_api;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TeamStatsFrag extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teamstats,container,false);
        TeamStatsBoxScore homeBoxScore = (TeamStatsBoxScore) getArguments().getSerializable("home");
        TeamStatsBoxScore awayBoxScore = (TeamStatsBoxScore) getArguments().getSerializable("away");

        TextView homeTeamName = (TextView)view.findViewById(R.id.home);
        homeTeamName.setText(homeBoxScore.getTEAM_NAME());

        TextView awayTeamName = (TextView)view.findViewById(R.id.away);
        awayTeamName.setText(awayBoxScore.getTEAM_NAME());
        return view;
    }
}
