package com.jitterted.datetimeformatter;

import com.jitterted.datetimeformatter.application.FabricatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FabricatorConfiguration {

    @Bean
    public FabricatorService fabricatorService() {
        return new FabricatorService();
    }

}
