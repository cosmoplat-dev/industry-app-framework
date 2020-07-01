package com.cosmoplat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 27279
 */
@SpringBootApplication
@MapperScan("com.cosmoplat.example.mapper")
@EnableJms
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
