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

public class AdapterWeather extends RecyclerView.Adapter<AdapterWeather.MyViewHolder>{

    private Context mContext;
    private List<WeatherAPI> mData;

    public AdapterWeather(Context mContext, List<WeatherAPI> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.weather_img, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.description.setText(mData.get(position).getDescription());
        holder.rainToday.setText(mData.get(position).getRainToday());
        holder.runningTime.setText(mData.get(position).getRunningTime());
        holder.snowToday.setText(mData.get(position).getSnowToday());
        holder.clouds.setText(mData.get(position).getClouds());
        holder.dewPoint.setText(mData.get(position).getDewPoint());
        holder.dt.setText(mData.get(position).getDt());
        holder.humidity.setText(mData.get(position).getHumidity());
        holder.pressure.setText(mData.get(position).getPressure());
        holder.dayTemp.setText(mData.get(position).getDayTemp());
        holder.eveTemp.setText(mData.get(position).getEveTemp());
        holder.maxTemp.setText(mData.get(position).getMaxTemp());
        holder.minTemp.setText(mData.get(position).getMinTemp());

//        holder.icon.setText(mData.get(position).getIcon());


        //Glide Implementation

        Glide.with(mContext)
                .load(mData.get(position).getIcon())
                .into(holder.icon);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView description, rainToday, runningTime, snowToday, clouds, dewPoint, dt, humidity, pressure, dayTemp, eveTemp, maxTemp, minTemp;
        ImageView icon;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            description=itemView.findViewById(R.id.description);
            icon=itemView.findViewById(R.id.icon);
            rainToday=itemView.findViewById(R.id.rainToday);
            runningTime=itemView.findViewById(R.id.runningTime);
            snowToday=itemView.findViewById(R.id.snowToday);
            clouds=itemView.findViewById(R.id.clouds);
            dewPoint=itemView.findViewById(R.id.dewPoint);
            dt=itemView.findViewById(R.id.dt);
            humidity=itemView.findViewById(R.id.humidity);
            pressure=itemView.findViewById(R.id.pressure);
            dayTemp=itemView.findViewById(R.id.dayTemp);
            eveTemp=itemView.findViewById(R.id.eveTemp);
            maxTemp=itemView.findViewById(R.id.maxTemp);
            minTemp=itemView.findViewById(R.id.minTemp);

        }
    }

}
