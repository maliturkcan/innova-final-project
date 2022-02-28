package com.kredi.innova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerDTO implements Serializable {

    private Long id;

    @NotNull(message = "Ad boş geçilemez")
    private String ad;

    @NotNull(message = "soyad boş geçilemez")
    private String soyad;

    @NotNull(message = "aylikGelir boş geçilemez")
    private BigDecimal aylikGelir;

    @NotNull(message = "telefonNo boş geçilemez")
    private String telefonNo;

    @NotNull(message = "tcNo boş geçilemez")
    private Long tcNo;

}
