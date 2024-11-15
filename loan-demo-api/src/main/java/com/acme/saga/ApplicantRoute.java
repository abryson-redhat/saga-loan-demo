package com.acme.saga;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;
import org.openapitools.model.*;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;

@Component
public class ApplicantRoute extends RouteBuilder {

    @Bean
    @Primary
    public Jackson2ObjectMapperBuilder customObjectMapper() {
        return new Jackson2ObjectMapperBuilder()
                // other configs are possible
                .modules(new JsonNullableModule());
    }

    
    @Override
    public void configure() throws Exception {
     
        

    }

}
