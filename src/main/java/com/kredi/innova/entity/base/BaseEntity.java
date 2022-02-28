package com.kredi.innova.entity.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdDate;

    @Column(name = "modified_at")
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date modifiedDate;

}
