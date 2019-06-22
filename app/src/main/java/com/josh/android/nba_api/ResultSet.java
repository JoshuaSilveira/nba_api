package com.josh.android.nba_api;

import java.util.HashMap;

public class ResultSet {

    private String name;
    private String[] headers;
    private String[][] rowSet;
    public HashMap<String,Game> gameset;
    public HashMap<String,LineScore> lineset;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public String[][] getRowset() {
        return rowSet;
    }

    public void setRowset(String[][] rowSet) {
        this.rowSet = rowSet;
    }

    public HashMap<String,Game> createGameHash(){
        gameset = new HashMap<>();
        for(int i =0;i<rowSet.length;i++){
            Game newGame = new Game();
            newGame.setGAME_DATE_EST(rowSet[i][0]);
            newGame.setGAME_SEQUENCE(rowSet[i][1]);
            newGame.setGAME_ID(rowSet[i][2]);
            newGame.setGAME_STATUS_ID(rowSet[i][3]);
            newGame.setGAME_STATUS_TEXT(rowSet[i][4]);
            newGame.setGAMECODE(rowSet[i][5]);
            newGame.setHOME_TEAM_ID(rowSet[i][6]);
            newGame.setVISITOR_TEAM_ID(rowSet[i][7]);
            newGame.setSEASON(rowSet[i][8]);
            newGame.setLIVE_PERIOD(rowSet[i][9]);
            newGame.setLIVE_PC_TIME(rowSet[i][10]);
            newGame.setNATL_TV_BROADCASTER_ABBREVIATION(rowSet[i][11]);

            newGame.setLIVE_PERIOD_TIME_BCAST(rowSet[i][12]);

            newGame.setWH_STATUS(rowSet[i][13]);
            gameset.put(rowSet[i][2],newGame);
        }
        return gameset;

    }

    public HashMap<String,LineScore> createLineHash(){
        lineset = new HashMap<>();

        for(int i =0;i<rowSet.length;i++){
            LineScore newLineScore = new LineScore();
            newLineScore.setGAME_DATE_EST(rowSet[i][0]);
            newLineScore.setGAME_SEQUENCE(rowSet[i][1]);
            newLineScore.setGAME_ID(rowSet[i][2]);
            newLineScore.setTEAM_ID(rowSet[i][3]);
            newLineScore.setTEAM_ABBREVIATION(rowSet[i][4]);
            newLineScore.setTEAM_CITY_NAME(rowSet[i][5]);
            newLineScore.setTEAM_WINS_LOSSES(rowSet[i][6]);
            newLineScore.setPTS_QTR1(rowSet[i][7]);
            newLineScore.setPTS_QTR2(rowSet[i][8]);
            newLineScore.setPTS_QTR4(rowSet[i][9]);
            newLineScore.setPTS_QTR4(rowSet[i][10]);
            newLineScore.setPTS_OT1(rowSet[i][11]);
            newLineScore.setPTS_OT2(rowSet[i][12]);
            newLineScore.setPTS_OT3(rowSet[i][13]);
            newLineScore.setPTS_OT4(rowSet[i][14]);
            newLineScore.setPTS_OT5(rowSet[i][15]);
            newLineScore.setPTS_OT6(rowSet[i][16]);
            newLineScore.setPTS_OT7(rowSet[i][17]);
            newLineScore.setPTS_OT8(rowSet[i][18]);
            newLineScore.setPTS_OT9(rowSet[i][19]);
            newLineScore.setPTS_OT10(rowSet[i][20]);
            newLineScore.setPTS(rowSet[i][21]);
            newLineScore.setFG_PCT(rowSet[i][22]);
            newLineScore.setFT_PCT(rowSet[i][23]);
            newLineScore.setFG3_PCT(rowSet[i][24]);
            newLineScore.setAST(rowSet[i][25]);
            newLineScore.setREB(rowSet[i][26]);
            newLineScore.setTOV(rowSet[i][27]);
            lineset.put(rowSet[i][3],newLineScore);


        }
        return lineset;
    }
    public HashMap<String,TeamStatsBoxScore> createTeamStatsBoxScore(){
        HashMap<String,TeamStatsBoxScore> teamMap = new HashMap<>();

        for(int i =0;i<rowSet.length;i++){
            TeamStatsBoxScore newTeamStatsBoxScore = new TeamStatsBoxScore();
            newTeamStatsBoxScore.setGAME_ID(rowSet[i][0]);
            newTeamStatsBoxScore.setTEAM_ID(rowSet[i][1]);
            newTeamStatsBoxScore.setTEAM_NAME(rowSet[i][2]);
            newTeamStatsBoxScore.setTEAM_ABBREVIATION(rowSet[i][3]);
            newTeamStatsBoxScore.setTEAM_CITY(rowSet[i][4]);
            newTeamStatsBoxScore.setMIN(rowSet[i][5]);
            newTeamStatsBoxScore.setFGM(rowSet[i][6]);
            newTeamStatsBoxScore.setFGA(rowSet[i][7]);
            newTeamStatsBoxScore.setFG_PCT(rowSet[i][8]);
            newTeamStatsBoxScore.setFG3M(rowSet[i][9]);
            newTeamStatsBoxScore.setFG3A(rowSet[i][10]);
            newTeamStatsBoxScore.setFG3_PCT(rowSet[i][11]);
            newTeamStatsBoxScore.setFTM(rowSet[i][12]);
            newTeamStatsBoxScore.setFTA(rowSet[i][13]);
            newTeamStatsBoxScore.setFT_PCT(rowSet[i][14]);
            newTeamStatsBoxScore.setOREB(rowSet[i][15]);
            newTeamStatsBoxScore.setDREB(rowSet[i][16]);
            newTeamStatsBoxScore.setREB(rowSet[i][17]);
            newTeamStatsBoxScore.setAST(rowSet[i][18]);
            newTeamStatsBoxScore.setSTL(rowSet[i][19]);
            newTeamStatsBoxScore.setBLK(rowSet[i][20]);
            newTeamStatsBoxScore.setTO(rowSet[i][21]);
            newTeamStatsBoxScore.setPF(rowSet[i][22]);
            newTeamStatsBoxScore.setPTS(rowSet[i][23]);
            newTeamStatsBoxScore.setPLUS_MINUS(rowSet[i][24]);
            teamMap.put(rowSet[i][1],newTeamStatsBoxScore);
        }
        return teamMap;
    }



}
