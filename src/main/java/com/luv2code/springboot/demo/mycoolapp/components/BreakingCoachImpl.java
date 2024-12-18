package com.luv2code.springboot.demo.mycoolapp.components;

import org.springframework.stereotype.Component;

@Component
public class BreakingCoachImpl implements Coach {
    public BreakingCoachImpl() {
        System.out.println("In constructor " + getClass().getSimpleName()); // For making sure that Bean has created.
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in Powermoves practice.";
    }
}
