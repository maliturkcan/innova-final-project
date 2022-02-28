package com.kredi.innova.entity;

import com.kredi.innova.entity.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "aylik_gelir")
    private BigDecimal aylikGelir;

    @Column(name = "telefon_no")
    private String telefonNo;

    @Column(name = "tc_no")
    private Long tcNo;

    @PrePersist
    public void persist() {
        this.setCreatedDate(new Date());
    }

    @PreUpdate
    public void update() {
        this.setModifiedDate(new Date());
    }

}
