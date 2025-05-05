package de.bcxp.challenge.model;

import com.opencsv.bean.CsvBindByName;

import java.text.NumberFormat;
import java.util.Locale;

public class CountryData {

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Population")
    private String population;

    @CsvBindByName(column = "Area (km²)")
    private String area;

    public String getName() {
        return name;
    }

    public double getPopulationDensity() {
        if (population == null || population.isEmpty() || area == null || area.isEmpty()) {
            return 0;
        }

        try {
            NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);

            String cleanedPopulation = population.trim().replace("\"", "").replace(".", "").replace(",", ".");
            String cleanedArea = area.trim().replace("\"", "").replace(".", "").replace(",", ".");

            double populationValue = Double.parseDouble(cleanedPopulation);
            double areaValue = Double.parseDouble(cleanedArea);

            if (areaValue == 0) return 0;

            return populationValue / areaValue;

        } catch (NumberFormatException e) {
            System.err.println("Error parsing numbers for country " + name + ": " + e.getMessage());
            return 0;
        }
    }

    @Override
    public String toString() {
        return "CountryData{" +
                "name='" + name + '\'' +
                ", population='" + population + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
