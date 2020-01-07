package com.fun.feifun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@SpringBootApplication
@EnableScheduling
@MapperScan("com.fun.feifun.modules.**.dao")
public class FeifunApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeifunApplication.class, args);
    }

}
