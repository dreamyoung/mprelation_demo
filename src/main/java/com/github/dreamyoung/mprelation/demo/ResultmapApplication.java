package com.github.dreamyoung.mprelation.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.github.dreamyoung.mprelation.demo.mapper")
@MapperScan("com.github.dreamyoung.mprelation.demo.mapper2")
@SpringBootApplication
//@ImportResource(locations = "classpath:transaction.xml") // @SpringBootApplication已经自动开启注解事务
public class ResultmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultmapApplication.class, args);
    }
}
