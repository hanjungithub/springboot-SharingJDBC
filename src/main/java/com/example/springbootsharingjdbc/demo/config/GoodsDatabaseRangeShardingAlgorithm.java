package com.example.springbootsharingjdbc.demo.config;

import com.alibaba.fastjson.JSON;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

@Component
public class GoodsDatabaseRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    private final static Logger logger = LoggerFactory.getLogger(GoodsDatabaseRangeShardingAlgorithm.class);
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        logger.info("Range : availableTargetNames:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(rangeShardingValue));
        Collection<String> result = new LinkedHashSet<>(collection.size());

        if( (rangeShardingValue.getValueRange()).hasLowerBound() &&(rangeShardingValue.getValueRange()).lowerEndpoint()<=20){
            result.add("ds0");
        }
        if( (rangeShardingValue.getValueRange()).hasUpperBound() &&(rangeShardingValue.getValueRange()).upperEndpoint()>=20){
            result.add("ds1");
        }
        return result;
    }
}
