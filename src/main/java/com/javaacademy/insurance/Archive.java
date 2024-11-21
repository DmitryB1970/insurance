package com.javaacademy.insurance;

import com.javaacademy.insurance.contract.InsuranceContract;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Archive {

    private Map<String, InsuranceContract> archiveOfContracts;

    public Map<String, InsuranceContract> putInArchive(InsuranceContract insuranceContract) {
        archiveOfContracts.put(insuranceContract.getContractNumber(), insuranceContract);
        return archiveOfContracts;
    }
}

