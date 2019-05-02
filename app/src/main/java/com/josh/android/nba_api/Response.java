package com.josh.android.nba_api;

import java.util.ArrayList;

public class Response {
    private String resource;

    public ArrayList<ResultSet> getResultSet() {
        return resultSets;
    }

    public void setResultSets(ArrayList<ResultSet> resultSets) {
        this.resultSets = resultSets;
    }

    private ArrayList<ResultSet> resultSets;






    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}

