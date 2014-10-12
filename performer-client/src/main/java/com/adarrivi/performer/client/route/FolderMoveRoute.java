package com.adarrivi.performer.client.route;

import com.adarrivi.performer.client.processor.SimpleProcessor;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FolderMoveRoute extends SpringRouteBuilder{
    @Value("${output.directory}")
    private String outputDirectory;
    @Value("${input.directory}")
    private String inputDirectory;

    @Autowired
    private SimpleProcessor simpleProcessor;

    @Override
    public void configure()  {
        from("file:" + inputDirectory).process(simpleProcessor).to("file:" + outputDirectory);
    }
}
