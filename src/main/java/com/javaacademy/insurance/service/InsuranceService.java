package com.javaacademy.insurance.service;

import com.javaacademy.insurance.InsuranceType;
import com.javaacademy.insurance.contract.InsuranceContract;

import java.math.BigDecimal;

public interface InsuranceService {

    InsuranceContract offerInsurance(BigDecimal coverageSum, String fio, InsuranceType type);

    InsuranceContract payForInsurance(String contractNumber);
}
