package com.example.springbootsharingjdbc.demo.config;

import com.alibaba.fastjson.JSON;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GoodsTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    private final static Logger logger = LoggerFactory.getLogger(GoodsTablePreciseShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        logger.info("Precise : availableTargetNames:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(preciseShardingValue));
        for (String each : collection) {
            if (each.endsWith(preciseShardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
