package com.javaacademy.insurance;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceContractNumberGenerator;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Archive {

    private InsuranceContractNumberGenerator insuranceContractNumberGenerator;
    @Getter
    private Map<String, InsuranceContract> contracts = new HashMap<>();

    public void addContract(InsuranceContract contract) {
        contracts.put(contract.getContractNumber(), contract);
    }
}

