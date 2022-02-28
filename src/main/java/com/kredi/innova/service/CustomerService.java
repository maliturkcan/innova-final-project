package com.kredi.innova.service;

import com.kredi.innova.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO kaydet (CustomerDTO customerDTO);
    void sil (Long id);
    CustomerDTO sorgula (Long id);
    void guncelle(Long id,CustomerDTO customerDTO);

}
