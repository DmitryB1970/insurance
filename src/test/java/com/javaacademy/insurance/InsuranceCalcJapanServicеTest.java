package com.javaacademy.insurance;

import com.javaacademy.insurance.calcservice.InsuranceCalcJapanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;


@SpringBootTest
@ActiveProfiles("japan")
@DisplayName("Расчёт страховой суммы в Японии")
public class InsuranceCalcJapanServicеTest {

    @Autowired
    private InsuranceCalcJapanService insuranceCalcJapanService;

    @Test
    @DisplayName("Успешный расчёт страховой суммы при грабеже")
    public void getInsuranceSumRobberySuccess() {
        BigDecimal result = insuranceCalcJapanService.contractSum(BigDecimal.valueOf(1_000_000),
                InsuranceType.ROBBERY_PROTECTION);
        BigDecimal expected = BigDecimal.valueOf(20_000);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Успешный расчёт страховой суммы при медицинской страховке")
    public void getInsuranceSumMedicalSuccess() {
        BigDecimal result = insuranceCalcJapanService.contractSum(BigDecimal.valueOf(10_000_000),
                InsuranceType.MEDICAL_INSURANCE);
        BigDecimal expected = BigDecimal.valueOf(162_000);
        Assertions.assertEquals(expected, result);
    }
}
