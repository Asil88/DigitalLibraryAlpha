package com.digital_library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")

public class JdbcConfiguration {

    Environment environment;

    @Autowired
    public JdbcConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        return driverManagerDataSource;
    }
}
