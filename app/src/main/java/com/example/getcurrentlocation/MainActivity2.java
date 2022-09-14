package com.example.getcurrentlocation;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {



    String url1;
//    String s8;
    List<WeatherAPI> weatherData;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String s1, s2, s3, s4, s5,s6,s7;

//      int i5;
        boolean b1,b2;

        s1 = getIntent().getStringExtra("Latitude");
        s2 = getIntent().getStringExtra("Longitude");
        s3 = getIntent().getStringExtra("Area");
//         s4 = getIntent().getStringExtra("Flow Rate");
        s5 = getIntent().getStringExtra("Rice");
//        s6 = getIntent().getStringExtra("Wheat");
//        s8=getIntent().getStringExtra("cropValueRadio");



        b1 = Boolean.parseBoolean(s5);
//        b2 = Boolean.parseBoolean(s6);
        if(b1) s7="2"; //For Rice
        else s7="1";   //For Wheat
//        if(b2) s7="1";


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        url1 = "https://jaisalabad.herokuapp.com/api_irrigation/111929343324/" + s1 + "/" + s2 + "/" + s3 + "/" + "1" + "/" + s7 + "/";
        weatherData = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        GetData getData = new GetData();
        getData.execute();


        // Request a string response from the provided URL.

//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,  new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                textView.setText(response.toString());
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity2.this, "Error Occurred!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        queue.add(request);
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,  new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
////                String str="A";
////                try {
////                    JSONObject cloud = response.getJSONObject(String.valueOf(0));
////                    str = cloud.getString("clouds");
////                }
////                catch (JSONException e){
////                    e.printStackTrace();
////                }
//
//                textView.setText(response.toString());
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity2.this, "Error Occurred!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        queue.add(request);
//
//    }
    }

    @SuppressLint("StaticFieldLeak")
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
                JSONObject jsonObject = new JSONObject(s);
                JSONObject owm = jsonObject.getJSONObject("OWM daily data");
                JSONObject temp= owm.getJSONObject("temp");
//                    JSONObject rainToday = jsonObject.getJSONObject("RAIN TODAY");
//                    JSONObject runningTime = jsonObject.getJSONObject("Runtime");
//                    JSONObject snowToday = jsonObject.getJSONObject("SNOW TODAY");

                JSONArray jsonArray = owm.getJSONArray("weather");


                WeatherAPI weather = new WeatherAPI();
                weather.setRainToday(jsonObject.getString("RAIN TODAY")+" mm");
                String str=jsonObject.getString("Runtime"+" litres");
//                double d= parseDouble(s8);
//                int rTime= (int) ((Integer.parseInt(str))*d);
//                str= rTime +" litres";
                weather.setRunningTime(str+" litres");
                weather.setSnowToday(jsonObject.getString("SNOW TODAY")+" mm");
                weather.setClouds(owm.getString("clouds")+"%");
                weather.setDewPoint(owm.getString("dew_point")+" "+(char) 0x00B0+"C");

                Date date = Calendar.getInstance().getTime();
                @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
                String strDate = dateFormat.format(date);
                weather.setDt(strDate);

                weather.setHumidity(owm.getString("humidity")+"%");
                weather.setPressure(owm.getString("pressure")+" millibar");
                weather.setDayTemp(temp.getString("day")+" "+(char) 0x00B0+"C");
                weather.setEveTemp(temp.getString("eve")+" "+(char) 0x00B0+"C");
                weather.setMaxTemp(temp.getString("max")+" "+(char) 0x00B0+"C");
                weather.setMinTemp(temp.getString("min")+" "+(char) 0x00B0+"C");



                for(int i=0; i<jsonArray.length();i++)
                {
                    String img;
                    String img2;
//                    String img3;

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    img = jsonObject1.getString("icon");
                    img2 = "http://openweathermap.org/img/wn/" + img + "@2x.png";


                    weather.setDescription(jsonObject1.getString("description"));
                    weather.setIcon(img2);
//                        weather.setMain(jsonObject1.getString("main"));
//                        img=jsonObject1.getString("icon");
//                        img="a"+img;
//                        Resources res = getResources();
//                        String mDrawableName = img;
//                        int resID = res.getIdentifier(img , "drawable", getPackageName());
//                        Drawable drawable = res.getDrawable(resID );
//                        //icon.setImageDrawable(drawable );

//                    weather.setIcon(jsonObject1.getString("icon"));
                    weatherData.add(weather);
                }



            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(weatherData);


        }
    }

    private void PutDataIntoRecyclerView(List<WeatherAPI> weatherData){
        AdapterWeather adapterWeather  = new AdapterWeather(this, weatherData);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterWeather);
    }
}