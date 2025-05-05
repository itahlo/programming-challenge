package de.bcxp.challenge.processor;

import de.bcxp.challenge.model.WeatherData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherProcessorTest {

    @Test
    void testSmallestTemperatureSpread() {
        List<WeatherData> testData = Arrays.asList(
                createWeatherData(1, 20, 10),
                createWeatherData(2, 15, 14),
                createWeatherData(3, 30, 20)
        );

        WeatherProcessor processor = new WeatherProcessor();
        WeatherData result = processor.process(testData);

        assertNotNull(result);
        assertEquals(2, result.getDay(), "The day with less difference should be 2.");
    }

    private WeatherData createWeatherData(int day, int max, int min) {
        WeatherData wd = new WeatherData();
        try {
            var dayField = WeatherData.class.getDeclaredField("day");
            var maxField = WeatherData.class.getDeclaredField("maxTemperature");
            var minField = WeatherData.class.getDeclaredField("minTemperature");
            dayField.setAccessible(true);
            maxField.setAccessible(true);
            minField.setAccessible(true);
            dayField.setInt(wd, day);
            maxField.setInt(wd, max);
            minField.setInt(wd, min);
        } catch (Exception e) {
            fail("Error preparing data for test: " + e.getMessage());
        }
        return wd;
    }
}
