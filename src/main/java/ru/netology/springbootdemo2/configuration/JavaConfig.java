package ru.netology.springbootdemo2.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemo2.profiles.DevProfile;
import ru.netology.springbootdemo2.profiles.ProductionProfile;
import ru.netology.springbootdemo2.profiles.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnMissingBean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}
