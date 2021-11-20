package com.example.getcurrentlocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterSensorWeather extends RecyclerView.Adapter<AdapterSensorWeather.MyViewHolder>{

    private Context mContext;
    private List<WeatherSensorAPI> mData;

    public AdapterSensorWeather(Context mContext, List<WeatherSensorAPI> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.weather_sensor, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.soilMoisture1.setText(mData.get(position).getSoilMoisture1());
        holder.soilMoisture2.setText(mData.get(position).getSoilMoisture2());
        holder.temp.setText(mData.get(position).getTemp());
        holder.humidity.setText(mData.get(position).getHumidity());
        holder.pressure.setText(mData.get(position).getPressure());
        holder.light.setText(mData.get(position).getLight());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView soilMoisture1, soilMoisture2, temp, humidity, pressure, light;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            soilMoisture1=itemView.findViewById(R.id.soilMoisture1);
            soilMoisture2=itemView.findViewById(R.id.soilMoisture2);
            temp=itemView.findViewById(R.id.temp);
            humidity=itemView.findViewById(R.id.humidity2);
            pressure=itemView.findViewById(R.id.pressure2);
            light=itemView.findViewById(R.id.light);

        }
    }

}
