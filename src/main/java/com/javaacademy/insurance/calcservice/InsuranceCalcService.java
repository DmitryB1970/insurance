package com.javaacademy.insurance.calcservice;

import com.javaacademy.insurance.InsuranceType;

import java.math.BigDecimal;


public interface InsuranceCalcService {

    BigDecimal contractSum(BigDecimal coverageSum, InsuranceType insuranceType);

}
