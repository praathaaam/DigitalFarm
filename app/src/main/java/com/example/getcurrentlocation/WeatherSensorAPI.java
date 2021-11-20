package com.example.getcurrentlocation;

public class WeatherSensorAPI {

    String soilMoisture1, SoilMoisture2, temp, humidity, pressure, light;

    public WeatherSensorAPI() {
    }

    public WeatherSensorAPI(String soilMoisture1, String soilMoisture2, String temp, String humidity, String pressure, String light) {
        this.soilMoisture1 = soilMoisture1;
        SoilMoisture2 = soilMoisture2;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.light = light;
    }

    public String getSoilMoisture1() {
        return soilMoisture1;
    }

    public void setSoilMoisture1(String soilMoisture1) {
        this.soilMoisture1 = soilMoisture1;
    }

    public String getSoilMoisture2() {
        return SoilMoisture2;
    }

    public void setSoilMoisture2(String soilMoisture2) {
        SoilMoisture2 = soilMoisture2;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }
}
