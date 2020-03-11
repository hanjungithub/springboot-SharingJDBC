package com.example.springbootsharingjdbc.demo.config;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @ClassName MyKeyGenerator
 * @Description TODO
 * @Author hanjun
 * @Date 2020/3/11 11:20
 **/
@Component
public class MyKeyGenerator implements ShardingKeyGenerator {
    public static long MyNum=0;
    @Override
    public Long generateKey() {
        return MyNum++;
    }

    @Override
    public String getType() {
        return "MyKeyGenerator";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
