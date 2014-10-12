package com.adarrivi.performer.client.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

@Configuration
@PropertySource({"classpath:performerClient.properties"})
public class ClientConfig {

    @Value("${queue.broker.url}")
    private String queueBrokerUrl;
    @Value("${queue.session.cacheSize}")
    private int queueSessionCacheSize;
    @Value("${queue.destination.name}")
    private String queueDestinationName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ConnectionFactory amqConnectionFactory() {
        return ClientConfigFactory.createConnectionFactory(queueBrokerUrl);
    }

    @Bean
    public ConnectionFactory cachedConnectionFactory(ConnectionFactory amqConnectionFactory) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setTargetConnectionFactory(amqConnectionFactory);
        connectionFactory.setSessionCacheSize(queueSessionCacheSize);
        return connectionFactory;
    }

    @Bean
    public Destination destinationQueue() {
        return new ActiveMQQueue(queueDestinationName);
    }

    @Bean
    public JmsTemplate producerTemplate(ConnectionFactory cachedConnectionFactory, Destination destinationQueue) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(cachedConnectionFactory);
        jmsTemplate.setDefaultDestination(destinationQueue);
        return jmsTemplate;
    }
}
