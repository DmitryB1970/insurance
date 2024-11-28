package com.javaacademy.insurance.contract;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Хотел сделать через файл с property, но не смог реализовать подтягивание значений. Оставил через @Value на полях
 */


@ConfigurationProperties
@Data
public class ContractProperty {

    private String currency;
    private String country;
    private double coefficientRobbery;
    private double coefficientMedical;
}
