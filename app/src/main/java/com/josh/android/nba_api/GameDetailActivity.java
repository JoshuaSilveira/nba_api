package com.josh.android.nba_api;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class GameDetailActivity extends AppCompatActivity {
    RequestQueue queue;
    String url;
    HashMap<String,TeamStatsBoxScore> teamStats;
    HashMap<String,PlayerStatsBoxScore> playerStats;
    String[] keys;
    String[] playerKeys;
    Gson g = new Gson();
    com.josh.android.nba_api.Response boxScore;

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Game game =(Game) intent.getSerializableExtra("game");

        url = "https://stats.nba.com/stats/boxscoretraditionalv2/?GameID="+game.getGAME_ID()+"&StartPeriod=10&EndPeriod=00&StartRange=00&EndRange=00&RangeType=00";
        GsonBuilder gsonBuilder = new GsonBuilder();
        g = gsonBuilder.create();
        queue = Volley.newRequestQueue(getApplicationContext());



        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.container);

        fetch();
    }

    private void setupViewPager(ViewPager viewPager,Bundle teamStatsBundle, Bundle playerStatsBundle){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        TeamStatsFrag teamStatsFrag = new TeamStatsFrag();
        teamStatsFrag.setArguments(teamStatsBundle);
        adapter.addFragment(teamStatsFrag,"Team Stats");

        PlayerStatsFrag playerStatsFrag = new PlayerStatsFrag();
        playerStatsFrag.setArguments(playerStatsBundle);
        adapter.addFragment(playerStatsFrag,"Player Stats");

        viewPager.setAdapter(adapter);

    }
    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }
    private void fetch(){
        StringRequest request = new StringRequest(Request.Method.GET,url,onLoaded,onError);
        queue.add(request);
    }
    private final Response.Listener<String> onLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            //Log.i("dog", response);
            boxScore = g.fromJson(response, com.josh.android.nba_api.Response.class);

            teamStats = boxScore.getResultSet().get(1).createTeamStatsBoxScore();
            playerStats = boxScore.getResultSet().get(0).getPlayerStatsHashMap();



            keys=new String[teamStats.size()];
            teamStats.keySet().toArray(keys);

            playerKeys=new String[playerStats.size()];
            playerStats.keySet().toArray(playerKeys);
            //Log.i("dog", playerStats.get(playerKeys[0]).getPLAYER_NAME());
            //Log.i("dog", playerStats.get(playerKeys[1]).getPLAYER_NAME());
            //Log.i("dog", playerStats.get(playerKeys[2]).getPLAYER_NAME());
            Bundle teamStatsBundle = new Bundle();

            teamStatsBundle.putSerializable("home",teamStats.get(keys[0]));
            teamStatsBundle.putSerializable("away",teamStats.get(keys[1]));
            teamStatsBundle.putStringArray("headers",boxScore.getResultSet().get(1).getHeaders());

            Bundle playerStatsBundle = new Bundle();
            playerStatsBundle.putSerializable("players",playerStats);


            setupViewPager(mViewPager,teamStatsBundle,playerStatsBundle);


        }
    };

    private final Response.ErrorListener onError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("error",error.toString());
        }
    };
}
