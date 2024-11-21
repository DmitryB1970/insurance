package com.javaacademy.insurance.calcservice;

import com.javaacademy.insurance.InsuranceType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;


@Profile("japan")
public class InsuranceCalcJapanService implements InsuranceCalcService {

    private static final BigDecimal ADD_PAYMENT_FOR_ROBBERY = BigDecimal.valueOf(10_000);
    private static final BigDecimal ADD_PAYMENT_FOR_MEDICAL = BigDecimal.valueOf(12_000);

    @Value("${app.coefficient.robbery}")
    private BigDecimal coefficientForRobbery;

    @Value("${app.coefficient.medical")
    private BigDecimal coefficientForMedical;

    @Override
    public BigDecimal contractSum(BigDecimal coverageSum, InsuranceType insuranceType) {
        if (insuranceType == InsuranceType.ROBBERY_PROTECTION) {
            coverageSum.multiply(coefficientForRobbery).add(ADD_PAYMENT_FOR_ROBBERY);
        } else if (insuranceType == InsuranceType.MEDICAL_INSURANCE) {
            coverageSum.multiply(coefficientForMedical).add(ADD_PAYMENT_FOR_MEDICAL);
        }
        return coverageSum;
    }
}
