package com.kredi.innova.service;

import com.kredi.innova.constans.KrediConstant;
import com.kredi.innova.dto.CreditResultDTO;
import com.kredi.innova.dto.CustomerCreditDTO;
import com.kredi.innova.types.CreditResultEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditScoreDummyService {

    private static final BigDecimal BESYUZ = new BigDecimal("500");
    private static final BigDecimal BIN = new BigDecimal("1000");

    public CreditResultDTO sorgula(CustomerCreditDTO customerCreditDTO) {
        BigDecimal krediSkoru = dummySkorUret(customerCreditDTO.getCustomerNumber());
        return skorSonucunuGetir(customerCreditDTO.getAylikGelir(), krediSkoru);
    }

    private BigDecimal dummySkorUret(Long customerNumber) {
        return BigDecimal.valueOf(Math.random() * 1500); // 0 - 1500  ==> 0-1500 arasi random değer
    }


    private CreditResultDTO skorSonucunuGetir(BigDecimal aylikGelir, BigDecimal krediSkoru) {
        if (krediSkoru.compareTo(BESYUZ) == -1) {
            return CreditResultDTO
                    .builder()
                    .sonuc(CreditResultEnum.RED.name())
                    .build();
        } else if (krediSkoru.compareTo(BESYUZ) != -1 && krediSkoru.compareTo(BIN) == -1 && aylikGelir.compareTo(new BigDecimal("5000")) == -1) {
            return CreditResultDTO
                    .builder()
                    .sonuc(CreditResultEnum.ONAY.name())
                    .limit(new BigDecimal("10000"))
                    .build();
        } else if (krediSkoru.compareTo(BESYUZ) != -1 && krediSkoru.compareTo(BIN) == -1 && aylikGelir.compareTo(new BigDecimal("5000")) != -1) {
            return CreditResultDTO
                    .builder()
                    .sonuc(CreditResultEnum.ONAY.name())
                    .limit(new BigDecimal("20000"))
                    .build();
        } else if (krediSkoru.compareTo(BIN) != -1) {
            return CreditResultDTO
                    .builder()
                    .sonuc(CreditResultEnum.ONAY.name())
                    .limit(aylikGelir.multiply(KrediConstant.VARSAYILAN_CARPAN))
                    .build();
        }
        return null;
    }

}
