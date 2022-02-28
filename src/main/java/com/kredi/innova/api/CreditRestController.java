package com.kredi.innova.api;

import com.kredi.innova.dto.CreditResultDTO;
import com.kredi.innova.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/credit")
@RequiredArgsConstructor
@Slf4j
public class CreditRestController {

    private final CreditService creditService;

    // http://localhost:8080/credit/sorgula/id/{id}
    @GetMapping("/sorgula/id/{id}")
    public CreditResultDTO krediSkoruSorgulaById(@PathVariable Long id) {
        return creditService.krediSkoruSorgulaById(id);
    }

    // http://localhost:8080/credit/sorgula/tcno/{tcNo}
    @GetMapping("/sorgula/tcno/{tcNo}")
    public CreditResultDTO krediSkoruSorgulaByTcNo(@PathVariable Long tcNo) {
        return creditService.krediSkoruSorgulaByTcNo(tcNo);
    }


}
