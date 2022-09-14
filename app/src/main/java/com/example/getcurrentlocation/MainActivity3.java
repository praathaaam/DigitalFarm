package com.example.getcurrentlocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;
import java.util.Date;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {



    String url1;
    List<WeatherSensorAPI> weatherData;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        url1 = "https://fasalbharat.herokuapp.com/download";
        weatherData = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        GetData getData = new GetData();
        getData.execute();



    }

    public class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(url1);
                    urlConnection = (HttpURLConnection) url.openConnection();


                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }

                    return current;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try{
//                long ut2 = System.currentTimeMillis() / 1000L;
//                System.out.println("Hello");
//                System.out.println(ut2);
//                String str =String.valueOf(ut2);
                JSONObject jsonObject = new JSONObject(s);
                JSONObject owm = jsonObject.getJSONObject("True");



                WeatherSensorAPI weather = new WeatherSensorAPI();

                weather.setSoilMoisture1(owm.getString("SM_1"));
                weather.setSoilMoisture2(owm.getString("SM_2"));
                weather.setTemp(owm.getString("Temp")+" "+(char) 0x00B0+"C");
                weather.setHumidity(owm.getString("Humd")+"%");
                weather.setPressure(owm.getString("Prsr")+" Pa");
                weather.setLight(owm.getString( "Light")+" lm");

                weatherData.add(weather);



            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(weatherData);


        }
    }

    private void PutDataIntoRecyclerView(List<WeatherSensorAPI> weatherData){
        AdapterSensorWeather adapterWeather  = new AdapterSensorWeather(this, weatherData);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterWeather);
    }
}