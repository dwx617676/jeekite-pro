package com.jeekite.online;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.jeekite.online.mapper")
@EnableSwagger2
public class JeekiteOnlie {
    public static void main(String[] args) {
        SpringApplication.run(JeekiteOnlie.class);

    }
}
