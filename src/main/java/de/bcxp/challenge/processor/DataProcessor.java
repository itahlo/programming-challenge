package de.bcxp.challenge.processor;

import java.util.List;

public interface DataProcessor<T> {
    T process(List<T> data);
}
