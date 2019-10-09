package com.wyb.footprint;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wyb.footprint.mapper")
@SpringBootApplication
public class FootprintApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootprintApplication.class, args);
    }

}
