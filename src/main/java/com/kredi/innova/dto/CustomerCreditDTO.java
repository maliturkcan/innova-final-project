package com.kredi.innova.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCreditDTO {
    Long customerNumber;
    BigDecimal aylikGelir;
}
