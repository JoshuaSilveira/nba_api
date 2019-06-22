package com.josh.android.nba_api;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements MyAdapter.OnGameListener {
//WTH
    private TextView mNoGames;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String date="01/13/2019";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private HashMap<String,Game> games;
    private HashMap<String,LineScore> scores;
    private String[] keys;
    com.josh.android.nba_api.Response egg;
    Gson g = new Gson();
    RequestQueue queue;
    Button mDay;

    ArrayList<HashMap<String, String>> gameList;
    String url = "https://stats.nba.com/stats/scoreboard/?GameDate="+date+"&LeagueID=00&DayOffset=0";
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stuff();
    }

    private void stuff(){
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(getApplicationContext());
        egg = new com.josh.android.nba_api.Response();
        GsonBuilder gsonBuilder = new GsonBuilder();
        g = gsonBuilder.create();
        games = new HashMap<String, Game>();
        scores = new HashMap<String,LineScore>();
        fetch();
        mDay=(Button)findViewById(R.id.button);
    }
    private void fetch(){
        StringRequest request = new StringRequest(Request.Method.GET, url,onLoaded, onError);
        queue.add(request);
    }

    private final Response.Listener<String> onLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            egg = g.fromJson(response, com.josh.android.nba_api.Response.class);
            games = egg.getResultSet().get(0).createGameHash();
            scores = egg.getResultSet().get(1).createLineHash();

            if(games.size()==0){
               mNoGames=(TextView)findViewById(R.id.NoGamesText);
               mNoGames.setText("No Games Today");
            }


            mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

            mLayoutManager = new LinearLayoutManager(getApplicationContext());
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new MyAdapter(games,scores,MainActivity.this);

            mRecyclerView.setAdapter(mAdapter);


            mDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_Material_Dialog_MinWidth,mDateSetListener,year,month,day);
                    dialog.show();
                }
            });

            mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    int fixedmonth=month+1;
                    date = fixedmonth+"/"+day+"/"+year;
                    url = "https://stats.nba.com/stats/scoreboard/?GameDate="+date+"&LeagueID=00&DayOffset=0";
                    stuff();
                }
            };





        }
    };
    private final Response.ErrorListener onError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("error",error.toString());
        }
    };


    @Override
    public void onGameClick(String position) {
        //Log.i("dog", "onGameClick: clicked");
        Intent intent = new Intent(this,GameDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("game",games.get(position));
        //Log.i("dog", games.get(position).getGAME_ID());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

