package com.example.dataroutetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dataroutetest.mapper")
public class DataRouteTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataRouteTestApplication.class, args);
    }
}
