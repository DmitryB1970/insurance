package com.javaacademy.insurance;

import com.javaacademy.insurance.calcservice.InsuranceCalcJapanService;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceContractNumberGenerator;
import com.javaacademy.insurance.contract.InsuranceContractStatus;
import com.javaacademy.insurance.service.InsuranceServiceJapan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;


/**
 * Здесь получается, что InsuranceContract contract -> NPE - не пойму почему...
 */

@SpringBootTest
@ActiveProfiles("japan")
public class InsuranceServiceJapanTest {

    private InsuranceContract contract;
    @Autowired
    private InsuranceServiceJapan insuranceServiceJapan;
    @MockBean
    private InsuranceCalcJapanService insuranceCalcJapanServiceMock;
    @MockBean
    private Archive archiveMock;
    @MockBean
    private InsuranceContractNumberGenerator insuranceContractNumberGeneratorMock;

    @Test
    public void insuranceOfferForRobberySuccess() {
        Mockito.when(insuranceContractNumberGeneratorMock.contractUniqueNumberGenerator()).thenReturn("001");
        Mockito.when(insuranceCalcJapanServiceMock.contractSum(BigDecimal.valueOf(1_000_000), InsuranceType.ROBBERY_PROTECTION)).thenReturn(BigDecimal.valueOf(20_000));

        InsuranceContract result = insuranceServiceJapan.offerInsurance(BigDecimal.valueOf(1_000_000), "Иванов Иван Иванович", InsuranceType.ROBBERY_PROTECTION);
    }


    @Test
    public void payForInsuranceSuccess() {

        InsuranceContract contract = new InsuranceContract("001",
                BigDecimal.valueOf(162_000),
                BigDecimal.valueOf(10_000_000),
                "Yen",
                "Иванов Иван Иванович",
                "Japan",
                InsuranceType.MEDICAL_INSURANCE);

        archiveMock.addContract(contract);

        InsuranceContract result = archiveMock.getContracts().get("001");
        System.out.println(result);
        InsuranceContract expected = insuranceServiceJapan.payForInsurance("001");
        System.out.println(result.getStatus());
        System.out.println(expected.getStatus());
        Assertions.assertEquals(expected, result);
    }
}
