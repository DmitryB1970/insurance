package com.javaacademy.insurance.service;

import com.javaacademy.insurance.InsuranceType;
import com.javaacademy.insurance.calcservice.InsuranceCalcJapanService;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceContractNumberGenerator;
import com.javaacademy.insurance.contract.InsuranceContractStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Profile("japan")
public class InsuranceServiceJapan implements InsuranceService {

    private InsuranceContractNumberGenerator insuranceContractNumberGenerator;
    private InsuranceCalcJapanService insuranceCalcJapanService;
    private InsuranceContract contract;


    @Override
    public InsuranceContract contractWithUnpaidStatus(BigDecimal coverageSum, String fio, InsuranceType type) {
        contract = new InsuranceContract(
                insuranceContractNumberGenerator.contractUniqueNumberGenerator(),
                insuranceCalcJapanService.contractSum(coverageSum, type), contract.getCountry(), coverageSum, contract.getCurrency(), fio,  InsuranceContractStatus.UNPAID_CONTRACT, type);
        return contract;
    }

    @Override
    public InsuranceContract contractWithPaidStatus(String contractNumber) {
        if (contractNumber.equals(null)) {
            throw new RuntimeException("такого договора не существует");
        }
        contract.setStatus(InsuranceContractStatus.PAID_CONTRACT);
        return contract;

    }
}
