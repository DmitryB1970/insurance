package com.javaacademy.insurance.contract;

import com.javaacademy.insurance.InsuranceType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;


@Getter
@RequiredArgsConstructor
public class InsuranceContract {

    private final String contractNumber;
    private final BigDecimal contractSum;
    private final BigDecimal coverageSum;
    @Value("${currency}")
    private final String currency;
    private final String fio;
    @Value("${country}")
    private final String country;
    private final InsuranceType type;
    @Setter
    private InsuranceContractStatus status = InsuranceContractStatus.UNPAID_CONTRACT;

}
