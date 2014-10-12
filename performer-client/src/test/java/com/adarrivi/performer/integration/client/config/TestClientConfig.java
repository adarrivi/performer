package com.adarrivi.performer.integration.client.config;

import com.adarrivi.performer.client.config.ClientCoreConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(ClientCoreConfig.class)
@PropertySource({"classpath:performerClientTest.properties"})
public class TestClientConfig {
}
