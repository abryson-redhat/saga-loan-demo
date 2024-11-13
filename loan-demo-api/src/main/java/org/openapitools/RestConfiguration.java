/**
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package com.acme.saga;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.model.rest.RestBindingMode;

@Component
public class RestConfiguration extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
            .scheme("http")
            .host("localhost")
            .component("servlet")
            .bindingMode(RestBindingMode.auto)
            .clientRequestValidation(false)
            .apiProperty("api.title", "Saga Loan Demo API")
            .apiProperty("api.version", "1.0.0");
    }
}