package com.luv2code.springboot.demo.mycoolapp.configs;

import com.luv2code.springboot.demo.mycoolapp.components.Coach;
import com.luv2code.springboot.demo.mycoolapp.components.SwimmingCoachImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquaticCoach")
    public Coach swimmingCoach() { // The Bean ID is the method name "swimmingCoach" by default if you don't configure Bean ID after @Bean.
        return new SwimmingCoachImpl();
    }
}
