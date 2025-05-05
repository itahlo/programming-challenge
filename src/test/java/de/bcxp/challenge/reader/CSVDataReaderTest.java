package de.bcxp.challenge.reader;

import de.bcxp.challenge.model.WeatherData;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVDataReaderTest {

    @Test
    void testWeatherDataReading() {
        DataReader<WeatherData> reader = new CSVDataReader<>(',');
        List<WeatherData> data = reader.readData("src/test/java/de/bcxp/challenge/resources/weather.csv", WeatherData.class);

        assertNotNull(data);
        assertFalse(data.isEmpty());
        assertEquals(30, data.size(), "Number of weather data should be 30.");

        WeatherData firstDay = data.get(0);
        assertEquals(1, firstDay.getDay(), "First Day should be 1.");
    }
}
