package com.josh.android.nba_api;

import java.io.Serializable;

public class PlayerStatsBoxScore implements Serializable {
    private String  GAME_ID;
    private String 	TEAM_ID;
    private String 	TEAM_ABBREVIATION;
    private String 	TEAM_CITY;
    private String 	PLAYER_ID;
    private String 	PLAYER_NAME;
    private String 	START_POSITION;
    private String 	COMMENT;
    private String 	MIN;
    private String 	FGM;
    private String 	FGA;
    private String 	FG_PCT;
    private String 	FG3M;
    private String 	FG3A;
    private String 	FG3_PCT;
    private String 	FTM;
    private String 	FTA;
    private String 	FT_PCT;
    private String 	OREB;
    private String 	DREB;
    private String 	REB;
    private String 	AST;
    private String 	STL;
    private String 	BLK;
    private String 	TO;
    private String 	PF;
    private String 	PTS;
    private String  PLUS_MINUS;

    public String getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(String GAME_ID) {
        this.GAME_ID = GAME_ID;
    }

    public String getTEAM_ID() {
        return TEAM_ID;
    }

    public void setTEAM_ID(String TEAM_ID) {
        this.TEAM_ID = TEAM_ID;
    }

    public String getTEAM_ABBREVIATION() {
        return TEAM_ABBREVIATION;
    }

    public void setTEAM_ABBREVIATION(String TEAM_ABBREVIATION) {
        this.TEAM_ABBREVIATION = TEAM_ABBREVIATION;
    }

    public String getTEAM_CITY() {
        return TEAM_CITY;
    }

    public void setTEAM_CITY(String TEAM_CITY) {
        this.TEAM_CITY = TEAM_CITY;
    }

    public String getPLAYER_ID() {
        return PLAYER_ID;
    }

    public void setPLAYER_ID(String PLAYER_ID) {
        this.PLAYER_ID = PLAYER_ID;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public void setPLAYER_NAME(String PLAYER_NAME) {
        this.PLAYER_NAME = PLAYER_NAME;
    }

    public String getSTART_POSITION() {
        return START_POSITION;
    }

    public void setSTART_POSITION(String START_POSITION) {
        this.START_POSITION = START_POSITION;
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public void setCOMMENT(String COMMENT) {
        this.COMMENT = COMMENT;
    }

    public String getMIN() {
        return MIN;
    }

    public void setMIN(String MIN) {
        this.MIN = MIN;
    }

    public String getFGM() {
        return FGM;
    }

    public void setFGM(String FGM) {
        this.FGM = FGM;
    }

    public String getFGA() {
        return FGA;
    }

    public void setFGA(String FGA) {
        this.FGA = FGA;
    }

    public String getFG_PCT() {
        return FG_PCT;
    }

    public void setFG_PCT(String FG_PCT) {
        this.FG_PCT = FG_PCT;
    }

    public String getFG3M() {
        return FG3M;
    }

    public void setFG3M(String FG3M) {
        this.FG3M = FG3M;
    }

    public String getFG3A() {
        return FG3A;
    }

    public void setFG3A(String FG3A) {
        this.FG3A = FG3A;
    }

    public String getFG3_PCT() {
        return FG3_PCT;
    }

    public void setFG3_PCT(String FG3_PCT) {
        this.FG3_PCT = FG3_PCT;
    }

    public String getFTM() {
        return FTM;
    }

    public void setFTM(String FTM) {
        this.FTM = FTM;
    }

    public String getFTA() {
        return FTA;
    }

    public void setFTA(String FTA) {
        this.FTA = FTA;
    }

    public String getFT_PCT() {
        return FT_PCT;
    }

    public void setFT_PCT(String FT_PCT) {
        this.FT_PCT = FT_PCT;
    }

    public String getOREB() {
        return OREB;
    }

    public void setOREB(String OREB) {
        this.OREB = OREB;
    }

    public String getDREB() {
        return DREB;
    }

    public void setDREB(String DREB) {
        this.DREB = DREB;
    }

    public String getREB() {
        return REB;
    }

    public void setREB(String REB) {
        this.REB = REB;
    }

    public String getAST() {
        return AST;
    }

    public void setAST(String AST) {
        this.AST = AST;
    }

    public String getSTL() {
        return STL;
    }

    public void setSTL(String STL) {
        this.STL = STL;
    }

    public String getBLK() {
        return BLK;
    }

    public void setBLK(String BLK) {
        this.BLK = BLK;
    }

    public String getTO() {
        return TO;
    }

    public void setTO(String TO) {
        this.TO = TO;
    }

    public String getPF() {
        return PF;
    }

    public void setPF(String PF) {
        this.PF = PF;
    }

    public String getPTS() {
        return PTS;
    }

    public void setPTS(String PTS) {
        this.PTS = PTS;
    }

    public String getPLUS_MINUS() {
        return PLUS_MINUS;
    }

    public void setPLUS_MINUS(String PLUS_MINUS) {
        this.PLUS_MINUS = PLUS_MINUS;
    }
}
