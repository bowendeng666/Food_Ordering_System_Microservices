package com.bowendeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bowendeng.repository")
public class MenuApp {
    public static void main(String[] args) {
        SpringApplication.run(MenuApp.class, args);
    }
}
