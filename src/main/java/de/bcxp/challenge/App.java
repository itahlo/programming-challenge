package de.bcxp.challenge;

import de.bcxp.challenge.model.CountryData;
import de.bcxp.challenge.model.WeatherData;
import de.bcxp.challenge.processor.CountryProcessor;
import de.bcxp.challenge.processor.WeatherProcessor;
import de.bcxp.challenge.reader.CSVDataReader;
import de.bcxp.challenge.reader.DataReader;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String[] args) {
        // defining path of files
        String weatherFilePath = "src/main/resources/de/bcxp/challenge/weather.csv";
        String countriesFilePath = "src/main/resources/de/bcxp/challenge/countries.csv";


        DataReader<WeatherData> weatherDataReader = new CSVDataReader<>(',');
        DataReader<CountryData> countryDataReader = new CSVDataReader<>(';');

        WeatherProcessor weatherProcessor = new WeatherProcessor();
        CountryProcessor countryProcessor = new CountryProcessor();

        // read and processing data from weather
        List<WeatherData> weatherDataList = weatherDataReader.readData(weatherFilePath, WeatherData.class);
        WeatherData dayWithSmallestTempSpread = weatherProcessor.process(weatherDataList);
        System.out.println("Day with smallest temperature spread: " + dayWithSmallestTempSpread.getDay());

        // read and process data from country
        List<CountryData> countryDataList = countryDataReader.readData(countriesFilePath, CountryData.class);
        CountryData countryWithHighestDensity = countryProcessor.process(countryDataList);
        System.out.println("Country with highest population density: " + countryWithHighestDensity.getName());
    }
}
