package com.javaacademy.insurance.contract;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InsuranceContractNumberGenerator {

    private List<String> contractNumber = new ArrayList<>();

    public String contractUniqueNumberGenerator() {
        Random random = new Random();
        int number = Math.abs(random.nextInt());
        String contNumber = String.valueOf(number);
        if (contractNumber.contains(contNumber)) {
            throw new RuntimeException("Такой номер договора уже есть. Задайте другой номер договора");
        }
        contractNumber.add(contNumber);
        return contNumber;
    }
}
