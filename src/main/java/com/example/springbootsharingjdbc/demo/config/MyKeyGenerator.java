package com.example.springbootsharingjdbc.demo.config;

import io.shardingsphere.core.keygen.KeyGenerator;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyKeyGenerator
 * @Description TODO
 * @Author hanjun
 * @Date 2020/3/11 11:20
 **/
@Component
public class MyKeyGenerator implements KeyGenerator {
    public static long MyNum=0;
    @Override
    public Number generateKey() {
        return MyNum++;
    }
}
