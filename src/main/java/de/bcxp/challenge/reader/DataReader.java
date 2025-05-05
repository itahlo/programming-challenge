package de.bcxp.challenge.reader;

import java.util.List;

public interface DataReader<T> {
    List<T> readData(String filePath, Class<T> clazz);
}
