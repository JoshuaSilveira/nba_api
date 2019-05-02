import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Test {
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";

    public static void main(String[] args) throws IOException {
        Test http = new Test();

        http.get();

    }
    private void get() throws IOException {
        String url ="https://stats.nba.com/stats/scoreboardV2/?GameDate=04/20/2019&LeagueID=00&DayOffset=0";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept-Encoding", ": gzip, deflate, br");
        connection.setRequestProperty("User-Agent",USER_AGENT);

        int responseCode = connection.getResponseCode();

        BufferedReader in = new BufferedReader( new InputStreamReader((connection.getInputStream())));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine())!=null){
            response.append(inputLine);
        }
        in.close();


        JsonObject j = new JsonObject();
        Gson g = new Gson();
        g.toJson(response.toString());



        Response egg = g.fromJson(response.toString(),Response.class);

        //String[][] answer = egg.getResultSet().get(0).getRowset();
        //System.out.println(answer.length);
        HashMap<Integer,Game> games = egg.getResultSet().get(0).createGameHash();
         //System.out.println(games.size());
        //games.forEach((k,v)->System.out.println(v.getGAMECODE()));



    }
}
