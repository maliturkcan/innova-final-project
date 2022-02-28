package com.kredi.innova.repository;

import com.kredi.innova.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select c from CustomerEntity c where c.tcNo = :tcNo ")
    CustomerEntity getByTcNo(@Param("tcNo") Long tcNo);
}
