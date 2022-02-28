package com.kredi.innova.api;

import com.kredi.innova.dto.CustomerDTO;
import com.kredi.innova.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerService customerService;

    // http://localhost:8080/customer/sorgula/{id}
    @GetMapping("/sorgula/{id}")
    public ResponseEntity<CustomerDTO> sorgula(@PathVariable Long id) {
        log.info("Müşteri sorgu işlemi başladı..");
        return ResponseEntity.ok(customerService.sorgula(id));
    }

    // http://localhost:8080/customer/kaydet/
    @PostMapping("/kaydet")
    public ResponseEntity<CustomerDTO> kaydet(@RequestBody @Valid CustomerDTO customerDTO) {
        log.info("Müşteri kayıt işlemi başladı..");
        return ResponseEntity.ok(customerService.kaydet(customerDTO));
    }

    // http://localhost:8080/customer/sil/{id}
    @DeleteMapping("/sil/{id}")
    public ResponseEntity<Boolean> sil(@PathVariable Long id) {
        customerService.sil(id);
        log.info("Müşteri silme işlemi başladı..");
        return ResponseEntity.ok(Boolean.TRUE);
    }

    // http://localhost:8080/customer/guncelle/{id}
    @PutMapping("/guncelle/{id}")
    public ResponseEntity<Boolean> guncelle(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerService.guncelle(id, customerDTO);
        log.info("Müşteri güncelleme işlemi başladı..");
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
