package com.example.springbootsharingjdbc.demo.config;

import com.alibaba.fastjson.JSON;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GoodsDatabasePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    private final static Logger logger = LoggerFactory.getLogger(GoodsDatabasePreciseShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        logger.info("Precise : availableTargetNames:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(preciseShardingValue));
        if(preciseShardingValue.getValue()<=20){
            return "ds0";
        }else{
            return "ds1";
        }
    }
}
