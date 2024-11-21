package com.javaacademy.insurance.config;

import com.javaacademy.insurance.calcservice.InsuranceCalcBrazilService;
import com.javaacademy.insurance.service.InsuranceServiceBrazil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("brazil")
public class BrazilConfig {


    @Bean
    public InsuranceCalcBrazilService insuranceCalcBrazilService() {
        return new InsuranceCalcBrazilService();
    }

    @Bean
    public InsuranceServiceBrazil insuranceServiceBrazil() {
        return new InsuranceServiceBrazil();
    }
}
