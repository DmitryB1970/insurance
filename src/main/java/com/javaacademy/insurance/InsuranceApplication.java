package com.javaacademy.insurance;

import com.javaacademy.insurance.calcservice.InsuranceCalcJapanService;
import com.javaacademy.insurance.calcservice.InsuranceCalcService;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceContractNumberGenerator;
import com.javaacademy.insurance.service.InsuranceServiceJapan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class InsuranceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InsuranceApplication.class, args);
        context.getBean(InsuranceCalcJapanService.class);

    }
}
