package com.adarrivi.performer.client.config;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ClientConfigFactory {

    public static ActiveMQConnectionFactory createConnectionFactory(String brokerUrl){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        return factory;
    }
}
