package com.jitterted.datetimeformatter;

import com.jitterted.datetimeformatter.application.FabricatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Configuration
public class FabricatorConfiguration {

    @Bean
    public FabricatorService fabricatorService() {
        ZonedDateTime exampleDate = ZonedDateTime.of(2022, 1, 5, 9, 15, 35, 111, ZoneOffset.UTC);
        return new FabricatorService(exampleDate);
    }

}
