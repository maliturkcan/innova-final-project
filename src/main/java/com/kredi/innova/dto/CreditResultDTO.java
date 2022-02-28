package com.kredi.innova.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CreditResultDTO implements Serializable {
    private String sonuc;
    private BigDecimal limit;
}
