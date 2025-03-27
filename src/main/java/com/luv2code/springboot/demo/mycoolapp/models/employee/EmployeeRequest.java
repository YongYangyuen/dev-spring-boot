package com.luv2code.springboot.demo.mycoolapp.models.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
