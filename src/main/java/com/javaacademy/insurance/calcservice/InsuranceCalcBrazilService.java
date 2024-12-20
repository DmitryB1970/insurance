package com.javaacademy.insurance.calcservice;

import com.javaacademy.insurance.InsuranceType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Profile("brazil")
public class InsuranceCalcBrazilService implements InsuranceCalcService {

    private static final BigDecimal ADD_PAYMENT_FOR_ROBBERY = BigDecimal.valueOf(300);
    private static final BigDecimal ADD_PAYMENT_FOR_MEDICAL = BigDecimal.valueOf(800);

    @Value("${coefficient.robbery}")
    private BigDecimal coefficientForRobbery;

    @Value("${coefficient.medical}")
    private BigDecimal coefficientForMedical;

    private BigDecimal result;

    @Override
    public BigDecimal contractSum(BigDecimal coverageSum, InsuranceType insuranceType) {
        if (insuranceType == InsuranceType.ROBBERY_PROTECTION) {
            result = coverageSum
                    .multiply(coefficientForRobbery)
                    .add(ADD_PAYMENT_FOR_ROBBERY)
                    .setScale(0, RoundingMode.HALF_UP);
        } else if (insuranceType == InsuranceType.MEDICAL_INSURANCE) {
            result = coverageSum
                    .multiply(coefficientForMedical)
                    .add(ADD_PAYMENT_FOR_MEDICAL)
                    .setScale(0, RoundingMode.HALF_UP);
        }
        return result;
    }
}
