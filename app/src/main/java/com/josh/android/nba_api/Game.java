package com.josh.android.nba_api;

public class Game {

    private String GAME_DATE_EST;
    private String GAME_SEQUENCE;
    private String GAME_ID;
    private String GAME_STATUS_ID;
    private String GAME_STATUS_TEXT;
    private String GAMECODE;
    private String HOME_TEAM_ID;
    private String VISITOR_TEAM_ID;
    private String SEASON;
    private String LIVE_PERIOD;
    private String LIVE_PC_TIME;
    private String NATL_TV_BROADCASTER_ABBREVIATION;
    private String HOME_TV_BROADCASTER_ABBREVIATION;
    private String AWAY_TV_BROADCASTER_ABBREVIATION;
    private String LIVE_PERIOD_TIME_BCAST;
    private String ARENA_NAME;
    private String WH_STATUS;

    private LineScore HOME_TEAM_LINESCORE;
    private LineScore AWAY_TEAM_LINESCORE;

    public String getGAME_DATE_EST() {
        return GAME_DATE_EST;
    }

    public void setGAME_DATE_EST(String GAME_DATE_EST) {
        this.GAME_DATE_EST = GAME_DATE_EST;
    }

    public String getGAME_SEQUENCE() {
        return GAME_SEQUENCE;
    }

    public void setGAME_SEQUENCE(String GAME_SEQUENCE) {
        this.GAME_SEQUENCE = GAME_SEQUENCE;
    }

    public String getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(String GAME_ID) {
        this.GAME_ID = GAME_ID;
    }

    public String getGAME_STATUS_ID() {
        return GAME_STATUS_ID;
    }

    public void setGAME_STATUS_ID(String GAME_STATUS_ID) {
        this.GAME_STATUS_ID = GAME_STATUS_ID;
    }

    public String getGAME_STATUS_TEXT() {
        return GAME_STATUS_TEXT;
    }

    public void setGAME_STATUS_TEXT(String GAME_STATUS_TEXT) {
        this.GAME_STATUS_TEXT = GAME_STATUS_TEXT;
    }

    public String getGAMECODE() {
        return GAMECODE;
    }

    public void setGAMECODE(String GAMECODE) {
        this.GAMECODE = GAMECODE;
    }

    public String getHOME_TEAM_ID() {
        return HOME_TEAM_ID;
    }

    public void setHOME_TEAM_ID(String HOME_TEAM_ID) {
        this.HOME_TEAM_ID = HOME_TEAM_ID;
    }

    public String getVISITOR_TEAM_ID() {
        return VISITOR_TEAM_ID;
    }

    public void setVISITOR_TEAM_ID(String VISITOR_TEAM_ID) {
        this.VISITOR_TEAM_ID = VISITOR_TEAM_ID;
    }

    public String getSEASON() {
        return SEASON;
    }

    public void setSEASON(String SEASON) {
        this.SEASON = SEASON;
    }

    public String getLIVE_PERIOD() {
        return LIVE_PERIOD;
    }

    public void setLIVE_PERIOD(String LIVE_PERIOD) {
        this.LIVE_PERIOD = LIVE_PERIOD;
    }

    public String getLIVE_PC_TIME() {
        return LIVE_PC_TIME;
    }

    public void setLIVE_PC_TIME(String LIVE_PC_TIME) {
        this.LIVE_PC_TIME = LIVE_PC_TIME;
    }

    public String getNATL_TV_BROADCASTER_ABBREVIATION() {
        return NATL_TV_BROADCASTER_ABBREVIATION;
    }

    public void setNATL_TV_BROADCASTER_ABBREVIATION(String NATL_TV_BROADCASTER_ABBREVIATION) {
        this.NATL_TV_BROADCASTER_ABBREVIATION = NATL_TV_BROADCASTER_ABBREVIATION;
    }

    public String getHOME_TV_BROADCASTER_ABBREVIATION() {
        return HOME_TV_BROADCASTER_ABBREVIATION;
    }

    public void setHOME_TV_BROADCASTER_ABBREVIATION(String HOME_TV_BROADCASTER_ABBREVIATION) {
        this.HOME_TV_BROADCASTER_ABBREVIATION = HOME_TV_BROADCASTER_ABBREVIATION;
    }

    public String getAWAY_TV_BROADCASTER_ABBREVIATION() {
        return AWAY_TV_BROADCASTER_ABBREVIATION;
    }

    public void setAWAY_TV_BROADCASTER_ABBREVIATION(String AWAY_TV_BROADCASTER_ABBREVIATION) {
        this.AWAY_TV_BROADCASTER_ABBREVIATION = AWAY_TV_BROADCASTER_ABBREVIATION;
    }

    public String getLIVE_PERIOD_TIME_BCAST() {
        return LIVE_PERIOD_TIME_BCAST;
    }

    public void setLIVE_PERIOD_TIME_BCAST(String LIVE_PERIOD_TIME_BCAST) {
        this.LIVE_PERIOD_TIME_BCAST = LIVE_PERIOD_TIME_BCAST;
    }

    public String getARENA_NAME() {
        return ARENA_NAME;
    }

    public void setARENA_NAME(String ARENA_NAME) {
        this.ARENA_NAME = ARENA_NAME;
    }

    public String getWH_STATUS() {
        return WH_STATUS;
    }

    public void setWH_STATUS(String WH_STATUS) {
        this.WH_STATUS = WH_STATUS;
    }

    public LineScore getHOME_TEAM_LINESCORE() {
        return HOME_TEAM_LINESCORE;
    }

    public void setHOME_TEAM_LINESCORE(LineScore HOME_TEAM_LINESCORE) {
        this.HOME_TEAM_LINESCORE = HOME_TEAM_LINESCORE;
    }

    public LineScore getAWAY_TEAM_LINESCORE() {
        return AWAY_TEAM_LINESCORE;
    }

    public void setAWAY_TEAM_LINESCORE(LineScore AWAY_TEAM_LINESCORE) {
        this.AWAY_TEAM_LINESCORE = AWAY_TEAM_LINESCORE;
    }
}
