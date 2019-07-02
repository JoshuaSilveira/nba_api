package com.josh.android.nba_api;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class PlayerStatsAdapter extends RecyclerView.Adapter<PlayerStatsAdapter.PlayerViewHolder> {

    private ArrayList<PlayerStatsBoxScore> mTeam1 = new ArrayList<>();
    private ArrayList<PlayerStatsBoxScore> mTeam2 = new ArrayList<>();

    public static class PlayerViewHolder extends RecyclerView.ViewHolder{
        public TextView	PLAYER_NAME;
        public TextView	START_POSITION;
        public TextView	COMMENT;
        public TextView	MIN;
        public TextView	FGM;
        public TextView	FGA;
        public TextView	FG_PCT;
        public TextView	FG3M;
        public TextView	FG3A;
        public TextView	FG3_PCT;
        public TextView	FTM;
        public TextView	FTA;
        public TextView	FT_PCT;
        public TextView	OREB;
        public TextView	DREB;
        public TextView	REB;
        public TextView	AST;
        public TextView	STL;
        public TextView	BLK;
        public TextView	TO;
        public TextView	PF;
        public TextView	PTS;
        public TextView PLUS_MINUS;

        public PlayerViewHolder(View v){
            super(v);

            PTS = v.findViewById(R.id.points);
            MIN = v.findViewById(R.id.minutes);
            START_POSITION = v.findViewById(R.id.position);
            FG_PCT = v.findViewById(R.id.fieldpercent);
            FT_PCT = v.findViewById(R.id.freethrowpercent);
            PLAYER_NAME = v.findViewById(R.id.playerNAME);
            REB = v.findViewById(R.id.rebounds);
            AST = v.findViewById(R.id.assists);
            /*START_POSITION = v.findViewById();
            COMMENT = v.findViewById();
            MIN = v.findViewById();
            FGM = v.findViewById();
            FGA = v.findViewById();
            FG_PCT = v.findViewById();
            FG3M = v.findViewById();
            FG3A = v.findViewById();
            FG3_PCT = v.findViewById();
            FTM = v.findViewById();
            FTA = v.findViewById();
            FT_PCT = v.findViewById();
            OREB = v.findViewById();
            DREB = v.findViewById();
            REB = v.findViewById();
            AST = v.findViewById();
            STL = v.findViewById();
            BLK = v.findViewById();
            TO = v.findViewById();
            PF = v.findViewById();
            PTS = v.findViewById();
            PLUS_MINUS = v.findViewById();*/
        }


    }



    public PlayerStatsAdapter(ArrayList<PlayerStatsBoxScore> team1, ArrayList<PlayerStatsBoxScore> team2) {
        mTeam1 = team1;
        mTeam2 = team2;
    }



    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.playerstatview,viewGroup,false);
        PlayerViewHolder holder = new PlayerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder playerViewHolder, int i) {
        playerViewHolder.PTS.setText(mTeam1.get(i).getPTS());
        playerViewHolder.MIN.setText(mTeam1.get(i).getMIN());
        playerViewHolder.PLAYER_NAME.setText(mTeam1.get(i).getPLAYER_NAME());
        playerViewHolder.START_POSITION.setText(mTeam1.get(i).getSTART_POSITION());
        playerViewHolder.FG_PCT.setText(mTeam1.get(i).getFG_PCT());
        playerViewHolder.FT_PCT.setText(mTeam1.get(i).getFT_PCT());
        playerViewHolder.AST.setText(mTeam1.get(i).getAST());
        playerViewHolder.REB.setText(mTeam1.get(i).getREB());
    }



    @Override
    public int getItemCount() {
        return mTeam1.size();
    }
}
