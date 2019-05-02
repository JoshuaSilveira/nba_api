package com.josh.android.nba_api;

import java.util.HashMap;

public class ResultSet {

    private String name;
    private String[] headers;
    private String[][] rowSet;
    public HashMap<Integer,Game> gameset;

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

    public HashMap<Integer,Game> createGameHash(){
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
            newGame.setLIVE_PC_TIME(rowSet[i][9]);
            newGame.setNATL_TV_BROADCASTER_ABBREVIATION(rowSet[i][10]);
            newGame.setHOME_TV_BROADCASTER_ABBREVIATION(rowSet[i][11]);
            newGame.setAWAY_TV_BROADCASTER_ABBREVIATION(rowSet[i][12]);
            newGame.setLIVE_PERIOD_TIME_BCAST(rowSet[i][13]);
            newGame.setARENA_NAME(rowSet[i][14]);
            newGame.setWH_STATUS(rowSet[i][15]);
            gameset.put(Integer.parseInt(rowSet[i][2]),newGame);
        }
        return gameset;

    }


}
