package com.javaacademy.insurance.config;

import com.javaacademy.insurance.calcservice.InsuranceCalcJapanService;
import com.javaacademy.insurance.contract.ContractProperty;
import com.javaacademy.insurance.service.InsuranceServiceJapan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Configuration
@EnableConfigurationProperties(value = ContractProperty.class)
@Profile("japan")
public class JapanConfig {

    private ContractProperty contractProperty;
    private String country;
    private String currency;
    private BigDecimal coefficientRobbery;
    private BigDecimal coefficientMedical;


    @Bean
    public InsuranceCalcJapanService insuranceCalcJapanService() {
        return new InsuranceCalcJapanService();
    }

    @Bean
    public InsuranceServiceJapan insuranceServiceJapan() {
        return new InsuranceServiceJapan();
    }
}
