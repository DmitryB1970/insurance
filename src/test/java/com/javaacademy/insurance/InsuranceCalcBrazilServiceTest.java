package com.javaacademy.insurance;

import com.javaacademy.insurance.calcservice.InsuranceCalcBrazilService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("brazil")
@DisplayName("Расчёт страховой суммы в Бразилии")
public class InsuranceCalcBrazilServiceTest {

    @Autowired
    private InsuranceCalcBrazilService insuranceCalcBrazilService;


    @Test
    @DisplayName("Успешный расчёт страховой суммы при грабеже")
    public void getInsuranceSumRobberySuccess () {
        BigDecimal result = insuranceCalcBrazilService.contractSum(BigDecimal.valueOf(50_000), InsuranceType.ROBBERY_PROTECTION);
        BigDecimal expected = BigDecimal.valueOf(2_800);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Успешный расчёт страховой суммы при медицинской страховке")
    public void getInsuranceSumMedicalSuccess () {
        BigDecimal result = insuranceCalcBrazilService.contractSum(BigDecimal.valueOf(200_000), InsuranceType.MEDICAL_INSURANCE);
        BigDecimal expected = BigDecimal.valueOf(6_800);
        Assertions.assertEquals(expected, result);
    }
}
