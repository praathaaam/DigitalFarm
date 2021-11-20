package com.example.getcurrentlocation;

public class WeatherAPI {
    String description, icon, rainToday, runningTime, snowToday, clouds, dewPoint, dt, humidity, pressure, dayTemp, eveTemp, maxTemp, minTemp;

    public String getDayTemp() {
        return dayTemp;
    }

    public void setDayTemp(String dayTemp) {
        this.dayTemp = dayTemp;
    }

    public String getEveTemp() {
        return eveTemp;
    }

    public void setEveTemp(String eveTemp) {
        this.eveTemp = eveTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public WeatherAPI(String description, String icon, String rainToday, String runningTime, String snowToday, String clouds, String dewPoint, String dt, String humidity, String pressure, String dayTemp, String eveTemp, String maxTemp, String minTemp) {
        this.description = description;
        this.icon = icon;
        this.rainToday = rainToday;
        this.runningTime = runningTime;
        this.snowToday = snowToday;
        this.clouds = clouds;
        this.dewPoint = dewPoint;
        this.dt = dt;
        this.humidity = humidity;
        this.pressure = pressure;
        this.dayTemp = dayTemp;
        this.eveTemp = eveTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
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

    public WeatherAPI() {
    }

    public String getRainToday() {
        return rainToday;
    }

    public void setRainToday(String rainToday) {
        this.rainToday = rainToday;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getSnowToday() {
        return snowToday;
    }

    public void setSnowToday(String snowToday) {
        this.snowToday = snowToday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
