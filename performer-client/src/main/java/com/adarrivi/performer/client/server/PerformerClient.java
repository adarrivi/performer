package com.adarrivi.performer.client.server;

import com.adarrivi.performer.client.domain.MeasurementEvent;

public interface PerformerClient {

    void sendEvent(MeasurementEvent event);
}
