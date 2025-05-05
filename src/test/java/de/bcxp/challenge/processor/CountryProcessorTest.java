package de.bcxp.challenge.processor;

import de.bcxp.challenge.model.CountryData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryProcessorTest {

    @Test
    void testHighestPopulationDensity() {
        List<CountryData> testData = Arrays.asList(
                createCountryData("Austria", "8926000", "83855"),
                createCountryData("Malta", "516100", "316"),
                createCountryData("Luxembourg", "633347", "2586")
        );

        CountryProcessor processor = new CountryProcessor();
        CountryData result = processor.process(testData);

        assertNotNull(result);
        assertEquals("Malta", result.getName(), "Malta should have highest population density.");
    }

    private CountryData createCountryData(String name, String population, String area) {
        CountryData cd = new CountryData();
        try {
            var nameField = CountryData.class.getDeclaredField("name");
            var populationField = CountryData.class.getDeclaredField("population");
            var areaField = CountryData.class.getDeclaredField("area");
            nameField.setAccessible(true);
            populationField.setAccessible(true);
            areaField.setAccessible(true);
            nameField.set(cd, name);
            populationField.set(cd, population);
            areaField.set(cd, area);
        } catch (Exception e) {
            fail("Error preparing data for test: " + e.getMessage());
        }
        return cd;
    }
}
