package com.javaacademy.insurance.service;

import com.javaacademy.insurance.Archive;
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
    @Autowired
    private InsuranceContractNumberGenerator insuranceContractNumberGenerator;
    @Autowired
    private InsuranceCalcJapanService insuranceCalcJapanService;

    private InsuranceContract contract;
    @Autowired
    private Archive archive;


    @Override
    public InsuranceContract offerInsurance(BigDecimal coverageSum, String fio, InsuranceType type) {
        InsuranceContract newContract = new InsuranceContract(
                insuranceContractNumberGenerator.contractUniqueNumberGenerator(),
                insuranceCalcJapanService.contractSum(coverageSum, type), coverageSum, contract.getCurrency(), fio, contract.getCountry(), InsuranceType.ROBBERY_PROTECTION);
        archive.addContract(newContract);
        return newContract;
    }

    @Override
    public InsuranceContract payForInsurance(String newContractNumber) {
        if (newContractNumber.isEmpty()) {
            throw new RuntimeException("такого договора не существует");
        }
        InsuranceContract contract = archive.getContracts().get(newContractNumber);
        contract.setStatus(InsuranceContractStatus.PAID_CONTRACT);
        return contract;
    }
}

