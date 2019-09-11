package com.lin.cangkusp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lin.cangkusp.dao")
@EnableTransactionManagement
public class CangkuspApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CangkuspApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CangkuspApplication.class);
    }
}
