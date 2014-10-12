package com.adarrivi.performer.client.server.impl;

import com.adarrivi.performer.client.domain.MeasurementEvent;
import com.adarrivi.performer.client.server.PerformerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
class PerformerClientImpl implements PerformerClient {

    @Autowired
    private JmsTemplate jmsTemplate;

    PerformerClientImpl() {
        //To favor Dependency Injection
    }
    @Override
    public void sendEvent(MeasurementEvent event) {

    }
}
