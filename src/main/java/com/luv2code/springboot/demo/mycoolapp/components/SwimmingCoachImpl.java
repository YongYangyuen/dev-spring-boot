package com.luv2code.springboot.demo.mycoolapp.components;

// No need to apply @Component because I used @Bean method within @Configuration file "SportConfig" instead.
public class SwimmingCoachImpl implements Coach {
    public SwimmingCoachImpl() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1,000 meters as a warm-up.";
    }
}
