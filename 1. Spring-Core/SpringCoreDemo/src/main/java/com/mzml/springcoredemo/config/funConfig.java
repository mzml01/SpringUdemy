package com.mzml.springcoredemo.config;

import com.mzml.springcoredemo.common.Arsenal;
import com.mzml.springcoredemo.common.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class funConfig {
    @Bean
    public Coach arsenal(){
        return new Arsenal();
    }
}
