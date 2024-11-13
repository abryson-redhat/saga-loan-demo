/**
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package com.acme.saga;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.openapitools.model.*;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.LoggingLevel;

@Component
public class AdminsApi extends RouteBuilder {

    @Bean
    @Primary
    public Jackson2ObjectMapperBuilder customObjectMapper() {
        return new Jackson2ObjectMapperBuilder()
                // other configs are possible
                .modules(new JsonNullableModule());
    }

    @Override
    public void configure() throws Exception {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JsonNullableModule());

        /**
        POST /saga/applicant : adds an applicant
        **/
        rest()
            .post("/saga/applicant")
                .description("adds an applicant")
                .id("addApplicantApi")
                .consumes("application/json")
                .type(Applicant.class)
                
                .param()
                    .name("applicant")
                    .type(RestParamType.body)
                    .required(false)
                    .description("Applicant to add")
                .endParam()
                .to("direct:addApplicant");
        

        /**
        POST /saga/loan : adds a loan
        **/
        rest()
            .post("/saga/loan")
                .description("adds a loan")
                .id("addLoanApi")
                .consumes("application/json")
                .type(Loan.class)
                
                .param()
                    .name("loan")
                    .type(RestParamType.body)
                    .required(false)
                    .description("Loan to add")
                .endParam()
                .to("direct:addLoan");
        

        /**
        POST /saga/createloan : creates a loan request
        **/
        rest()
            .post("/saga/createloan")
                .description("creates a loan request")
                .id("createLoanApi")
                .consumes("application/json")
                .type(LoanRequest.class)
                
                .param()
                    .name("loanRequest")
                    .type(RestParamType.body)
                    .required(false)
                    .description("Loan request")
                .endParam()
                .to("direct:createLoan");
        
        from("direct:addApplicant")
            .log("Applicant added...");

        from("direct:addLoan")
            .process( exchange -> {
                Loan loan = (Loan) exchange.getIn().getBody(Loan.class);
                log.info("loan->id: " + loan.getId().toString() + 
                         ", amount: " + loan.getAmount().toString() +
                         ", applicantId: " + loan.getApplicantId().toString() +
                         ", approved: " + loan.getApproved().toString() +
                         ", loanRequestDate: " + loan.getLoanRequestDate().toString());
            })
            .log("Loan added...");    

        from("direct:createLoan")
            .log("Create loan...");                
    }
}