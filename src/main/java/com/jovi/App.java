package com.jovi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
// Spring Boot 应用的标识
@SpringBootApplication
@MapperScan("com.jovi.mapper")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
