package com.adarrivi.performer.integration.client;

import com.adarrivi.performer.integration.client.config.TestClientConfig;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestClientConfig.class})
public abstract class GenericClientIntegrationTest {

    @Autowired
    private CamelContext context;


    protected void runCamelAndWaitForItToFinish(){
        try {
            context.start();
            context.stop();
        } catch (Exception e) {
            Assert.fail("Couldn't run camel because: " + e.getMessage());
        }
    }


}
