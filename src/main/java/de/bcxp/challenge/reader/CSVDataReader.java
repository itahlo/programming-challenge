package de.bcxp.challenge.reader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSVDataReader<T> implements DataReader<T> {

    private final char delimiter;

    public CSVDataReader(char delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<T> readData(String filePath, Class<T> clazz) {
        try (Reader reader = new FileReader(filePath)) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withSeparator(delimiter)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true) // ignore empty lines
                    .build();

            return csvToBean.parse().stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
