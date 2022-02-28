package com.kredi.innova.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    @JsonFormat(pattern = "yyyy-mm-dd hh:MM:ss")
    private Date timestamp;
    private List<String> messageList=new ArrayList<>();
    private String description;

    public void addError(String errorMessage) {
        this.getMessageList().add(errorMessage);
    }

}