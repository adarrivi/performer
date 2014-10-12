package com.adarrivi.performer.client.domain;

public interface MeasurementEvent {
    int getTimeTakenInMs();
    int getOccurrences();
    String getType();
    String getSubType();
}
