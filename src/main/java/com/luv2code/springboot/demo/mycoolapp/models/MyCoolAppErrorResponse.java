package com.luv2code.springboot.demo.mycoolapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCoolAppErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
