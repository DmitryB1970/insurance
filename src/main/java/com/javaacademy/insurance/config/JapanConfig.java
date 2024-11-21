package com.javaacademy.insurance.config;

import com.javaacademy.insurance.calcservice.InsuranceCalcJapanService;
import com.javaacademy.insurance.service.InsuranceServiceJapan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("japan")
public class JapanConfig {

    @Bean
    public InsuranceCalcJapanService insuranceCalcJapanService() {
        return new InsuranceCalcJapanService();
    }

    @Bean
    public InsuranceServiceJapan insuranceServiceJapan() {
        return new InsuranceServiceJapan();
    }
}
