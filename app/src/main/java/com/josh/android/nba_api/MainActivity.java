package com.josh.android.nba_api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private TextView txt;

    ArrayList<HashMap<String, String>> gameList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://stats.nba.com/stats/scoreboard/?GameDate=01/17/2019&LeagueID=00&DayOffset=0";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {

                            JSONArray scoreboard = new JSONArray();
                        try {
                            scoreboard = response.getJSONArray("resultSets");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                            JSONObject headLine = new JSONObject();
                        try {
                            headLine = scoreboard.getJSONObject(0);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray headLineArray = new JSONArray();

                        try {
                            headLineArray = headLine.getJSONArray("rowSet");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        int gameID=0;
                        for(int i =0;i<headLineArray.length();i++){
                            JSONArray currentGame = new JSONArray();
                            try {
                                currentGame = headLineArray.getJSONArray(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            try {
                                gameID = currentGame.getInt(2);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        txt.setText("response : "+ gameID);


                        //txt.setText();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

// Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);



    }
}
