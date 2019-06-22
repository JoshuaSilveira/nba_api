package com.josh.android.nba_api;

import java.util.ArrayList;

public class Response {
    private String resource;

    private ArrayList<ResultSet> resultSets;


    public ArrayList<ResultSet> getResultSet() {
        return resultSets;
    }

    public void setResultSets(ArrayList<ResultSet> resultSets) {
        this.resultSets = resultSets;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }



}

