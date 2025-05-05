package de.bcxp.challenge.processor;

import de.bcxp.challenge.model.WeatherData;

import java.util.Comparator;
import java.util.List;

public class WeatherProcessor implements DataProcessor<WeatherData> {

    @Override
    public WeatherData process(List<WeatherData> data) {
        return data.stream()
                .min(Comparator.comparingInt(WeatherData::getTemperatureSpread))
                .orElseThrow(() -> new IllegalStateException("Weather data list is empty or invalid."));
    }
}
