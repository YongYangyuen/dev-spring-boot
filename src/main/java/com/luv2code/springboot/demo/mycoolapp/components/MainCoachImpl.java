package com.luv2code.springboot.demo.mycoolapp.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MainCoachImpl implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes to do any exercise.";
    }
}
