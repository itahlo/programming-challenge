package de.bcxp.challenge.processor;

import de.bcxp.challenge.model.CountryData;

import java.util.Comparator;
import java.util.List;

public class CountryProcessor implements DataProcessor<CountryData> {

    @Override
    public CountryData process(List<CountryData> data) {
        return data.stream()
                .max(Comparator.comparingDouble(CountryData::getPopulationDensity))
                .orElseThrow(() -> new IllegalStateException("Country data list is empty or invalid."));
    }
}
