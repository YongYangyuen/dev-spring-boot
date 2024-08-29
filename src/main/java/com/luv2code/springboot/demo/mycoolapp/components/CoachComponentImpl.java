package com.luv2code.springboot.demo.mycoolapp.components;

import org.springframework.stereotype.Component;

@Component
public class CoachComponentImpl implements CoachComponent {
    @Override
    public String getDailyWorkout() {
        return "Practice breaking for 3 hours.";
    }
}
