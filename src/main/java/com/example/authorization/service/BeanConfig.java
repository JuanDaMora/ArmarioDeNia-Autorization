package com.example.authorization.service;

import com.example.authorization.service.impl.*;
import com.example.authorization.service.interfaces.*;

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
    @Bean
    public IColorService colorService() { return new ColorServiceImpl();  }
    @Bean
    public IAuthorizationService authorizationService() { return new AuthorizationServiceImpl(); }
    @Bean
    public IsAdminService adminService() { return new IsAdminServiceImpl(); }
    @Bean
    public IProductService productService() { return new ProductServiceImpl(); }

}