package com.luv2code.springboot.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class TeacherImpl implements Teacher {
    @Override
    public String teachMath() {
        return "1 + 1 = 2";
    }

    @Override
    public String teachComp() {
        return "1 + 1 = 0 (In binary)";
    }
}
