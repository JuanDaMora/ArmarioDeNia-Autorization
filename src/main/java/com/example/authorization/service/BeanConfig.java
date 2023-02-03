package com.example.authorization.service;

import com.example.authorization.service.impl.AuthorizationServiceImpl;
import com.example.authorization.service.impl.UserServiceImpl;
import com.example.authorization.service.interfaces.IAuthorizationService;
import com.example.authorization.service.interfaces.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @autor Juan David Morantes Vergara
 */
@Configuration
@ComponentScan("com.example.authorization.service")
public class BeanConfig {

    @Bean
    public IUserService userService() {
        return new UserServiceImpl();
    }
    @Bean(name="beanName")
    public IAuthorizationService authorizationService() {
        return new AuthorizationServiceImpl();
    }
}