package com.example.springbootsharingjdbc.demo.config;

import com.alibaba.fastjson.JSON;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

@Component
public class GoodsTableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    private final static Logger logger = LoggerFactory.getLogger(GoodsTableRangeShardingAlgorithm.class);
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        logger.info("Range : availableTargetNames:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(rangeShardingValue));
        Collection<String> result = new LinkedHashSet<>(collection.size());
       /* for (Long value : rangeShardingValue.getValueRange()) {
            for (String tableName : collection) {
                if (tableName.endsWith(value % 2 + "")) {
                    result.add(tableName);
                }
            }
        }*/
       return result;
    }
}
