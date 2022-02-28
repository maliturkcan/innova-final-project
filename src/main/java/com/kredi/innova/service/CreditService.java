package com.kredi.innova.service;

import com.kredi.innova.dto.CreditResultDTO;

public interface CreditService {

    CreditResultDTO krediSkoruSorgulaById(Long id);
    CreditResultDTO krediSkoruSorgulaByTcNo(Long tcNo);

}
