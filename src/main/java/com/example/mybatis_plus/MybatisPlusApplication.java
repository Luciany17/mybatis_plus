package com.example.mybatis_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class MybatisPlusApplication {

    public static void main(String[] args) {
        System.out.println("hello,git");
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}