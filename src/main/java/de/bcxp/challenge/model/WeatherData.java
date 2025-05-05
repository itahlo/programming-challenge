package de.bcxp.challenge.model;

import com.opencsv.bean.CsvBindByName;

public class WeatherData {

    @CsvBindByName(column = "Day")
    private int day;

    @CsvBindByName(column = "MxT")
    private int maxTemperature;

    @CsvBindByName(column = "MnT")
    private int minTemperature;

    public int getDay() {
        return day;
    }

    public int getTemperatureSpread() {
        return Math.abs(maxTemperature - minTemperature);
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "day=" + day +
                ", maxTemperature=" + maxTemperature +
                ", minTemperature=" + minTemperature +
                '}';
    }
}
