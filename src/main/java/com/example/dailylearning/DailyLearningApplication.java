package com.example.dailylearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//TODO 项目启动时自动注入mapper。
@MapperScan(basePackages = {"com.example.dailylearning.web.dao"})
public class DailyLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyLearningApplication.class, args);
    }
}
