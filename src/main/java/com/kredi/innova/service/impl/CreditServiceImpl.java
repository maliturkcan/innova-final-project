package com.kredi.innova.service.impl;

import com.kredi.innova.dto.CreditResultDTO;
import com.kredi.innova.dto.CustomerCreditDTO;
import com.kredi.innova.entity.CustomerEntity;
import com.kredi.innova.exception.EntityNotFoundException;
import com.kredi.innova.repository.CustomerRepository;
import com.kredi.innova.service.CreditService;
import com.kredi.innova.service.CreditScoreDummyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("creditService")
@RequiredArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService {

    private final CreditScoreDummyService creditScoreDummyService;
    private final CustomerRepository customerRepository;


    @Override
    @Transactional(readOnly = true)
    public CreditResultDTO krediSkoruSorgulaById(Long id) {
        CustomerEntity customerEntity = customerRepository.getById(id);
        if (customerEntity == null)
            throw new EntityNotFoundException(id + " id li müşteri bulunamamıştır.");
        CustomerCreditDTO customerCreditDTO = CustomerCreditDTO
                .builder()
                .customerNumber(customerEntity.getId())
                .aylikGelir(customerEntity.getAylikGelir())
                .build();
        return creditScoreDummyService.sorgula(customerCreditDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public CreditResultDTO krediSkoruSorgulaByTcNo(Long tcNo) {
        CustomerEntity customerEntity = customerRepository.getByTcNo(tcNo);
        if (customerEntity == null)
            throw new EntityNotFoundException(tcNo + " TC kimlik no lu müşteri bulunamamıştır.");

        CustomerCreditDTO customerCreditDTO = CustomerCreditDTO
                .builder()
                .customerNumber(customerEntity.getId())
                .aylikGelir(customerEntity.getAylikGelir())
                .build();
        return creditScoreDummyService.sorgula(customerCreditDTO);
    }


}
