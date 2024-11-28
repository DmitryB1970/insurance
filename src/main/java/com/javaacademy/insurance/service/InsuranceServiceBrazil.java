package com.javaacademy.insurance.service;

import com.javaacademy.insurance.InsuranceType;
import com.javaacademy.insurance.calcservice.InsuranceCalcJapanService;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceContractNumberGenerator;
import com.javaacademy.insurance.contract.InsuranceContractStatus;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Profile("brazil")
public class InsuranceServiceBrazil implements InsuranceService {

    private InsuranceContractNumberGenerator insuranceContractNumberGenerator;
    private InsuranceCalcJapanService insuranceCalcJapanService;
    private InsuranceContract contract;

    @Override
    public InsuranceContract offerInsurance(BigDecimal coverageSum, String fio, InsuranceType type) {
        contract = new InsuranceContract(
                insuranceContractNumberGenerator.contractUniqueNumberGenerator(),
                insuranceCalcJapanService.contractSum(coverageSum, type),
                coverageSum,
                contract.getCurrency(),
                fio,
                contract.getCountry(),
                type);
        return contract;
    }

    @Override
    public InsuranceContract payForInsurance(String contractNumber) {
        if (contractNumber.isEmpty()) {
            throw new RuntimeException("такого договора не существует");
        }
        contract.setStatus(InsuranceContractStatus.PAID_CONTRACT);

        return contract;
    }
}