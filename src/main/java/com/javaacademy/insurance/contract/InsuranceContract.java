package com.javaacademy.insurance.contract;

import com.javaacademy.insurance.InsuranceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;


@Getter
public class InsuranceContract {

    private String contractNumber;
    private BigDecimal contractSum;
    private BigDecimal coverageSum;
    @Value("${app.currency}")
    private String currency;
    private String fio;
    @Value("${app.country}")
    private String country;
    private InsuranceType type;
    @Setter
    private InsuranceContractStatus status;

    public InsuranceContract(String contractNumber, BigDecimal contractSum, String country, BigDecimal coverageSum, String currency, String fio, InsuranceContractStatus status, InsuranceType type) {
        this.contractNumber = contractNumber;
        this.contractSum = contractSum;
        this.country = country;
        this.coverageSum = coverageSum;
        this.currency = currency;
        this.fio = fio;
        this.status = status;
        this.type = type;
    }
}
