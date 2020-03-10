package com.example.springbootsharingjdbc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.**.mapper")
public class DemoApplication {
    private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        logger.error("ヾ(◍°∇°◍)ﾉﾞ      启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }

}
