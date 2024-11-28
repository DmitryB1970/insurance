package com.javaacademy.insurance.calcservice;

import com.javaacademy.insurance.InsuranceType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Profile("japan")
public class InsuranceCalcJapanService implements InsuranceCalcService {

    private static final BigDecimal ADD_PAYMENT_FOR_ROBBERY = BigDecimal.valueOf(10_000);
    private static final BigDecimal ADD_PAYMENT_FOR_MEDICAL = BigDecimal.valueOf(12_000);

    @Value("${coefficient.robbery}")
    private BigDecimal coefficientRobbery;

    @Value("${coefficient.medical}")
    private BigDecimal coefficientMedical;

    private BigDecimal result;

    @Override
    public BigDecimal contractSum(BigDecimal coverageSum, InsuranceType insuranceType) {
        if (insuranceType == InsuranceType.ROBBERY_PROTECTION) {
            result = coverageSum
                    .multiply(coefficientRobbery)
                    .add(ADD_PAYMENT_FOR_ROBBERY)
                    .setScale(0, RoundingMode.HALF_UP);
        } else if (insuranceType == InsuranceType.MEDICAL_INSURANCE) {
            result = coverageSum
                    .multiply(coefficientMedical)
                    .add(ADD_PAYMENT_FOR_MEDICAL)
                    .setScale(0, RoundingMode.HALF_UP);
        }
        return result;
    }
}
