package com.kredi.innova.service.impl;

import com.kredi.innova.dto.CustomerDTO;
import com.kredi.innova.entity.CustomerEntity;
import com.kredi.innova.exception.EntityNotFoundException;
import com.kredi.innova.repository.CustomerRepository;
import com.kredi.innova.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public CustomerDTO kaydet(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        //customerEntity.setAd(customerDTO.getAd());
        customerEntity = customerRepository.save(customerEntity);
        log.info(customerDTO.getTcNo() + " TC no lu Müşteri kayıt işlemi başarıyla tamamlandı.");

        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    @Override
    @Transactional
    public void sil(Long id) {
        customerRepository.deleteById(id);
        log.info(id + " Id'li Müşteri silme işlemi başarıyla tamamlandı.");
    }

    @Override
    @Transactional
    public void guncelle(Long id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(id);
        if (customerEntityOpt.isEmpty())
            throw new EntityNotFoundException(id + "id li, Güncellemek istediğiniz kayıt bulunamadı");
        log.info("Müşteri güncellenmeden önce : " + customerEntityOpt.get().toString());
        customerGuncelle(customerEntityOpt.get(), customerDTO);
        CustomerEntity customerEntity = customerRepository.save(customerEntityOpt.get());
        log.info("Müşteri güncellendikten sonra : " + customerEntity.toString());
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDTO sorgula(Long id) {
        Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(id);

        if (customerEntityOpt.isEmpty())
            throw new EntityNotFoundException(id + " li değerli kayıt veritabanında mevcut değildir.");

        return modelMapper.map(customerEntityOpt.get(), CustomerDTO.class);
    }

    private void customerGuncelle(CustomerEntity customerEntity, CustomerDTO customerDTO) {
        customerEntity.setAd(customerDTO.getAd() != null ? customerDTO.getAd() : customerEntity.getAd());
        customerEntity.setSoyad(customerDTO.getSoyad() != null ? customerDTO.getSoyad() : customerEntity.getSoyad());
        customerEntity.setAylikGelir(customerDTO.getAylikGelir() != null ? customerDTO.getAylikGelir() : customerEntity.getAylikGelir());
        customerEntity.setTcNo(customerDTO.getTcNo() != null ? customerDTO.getTcNo() : customerEntity.getTcNo());
        customerEntity.setTelefonNo(customerDTO.getTelefonNo() != null ? customerDTO.getTelefonNo() : customerEntity.getTelefonNo());
    }
}
