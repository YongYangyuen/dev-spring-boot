package com.luv2code.springboot.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class StudentImpl implements Student {
    @Override
    public String studyMath() {
        return "0 + 0 = 0 and 0 + 1 = 1 and 1 + 0 = 1";
    }

    @Override
    public String studyComp() {
        return "0 + 0 = 0 and 0 + 1 = 1 and 1 + 0 = 1 (In Binary as well)";
    }
}
