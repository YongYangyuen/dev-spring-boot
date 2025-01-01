package com.luv2code.springboot.demo.mycoolapp.components;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("breakingCoach") // Able to configure Component ID as well as Bean ID in @Configuration.
public class BreakingCoachImpl implements Coach {
    public BreakingCoachImpl() {
        System.out.println("In constructor " + getClass().getSimpleName()); // For making sure that Bean has created.
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in Powermoves practice.";
    }
}
