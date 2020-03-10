package com.example.springbootsharingjdbc.demo.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import io.shardingsphere.core.routing.strategy.standard.StandardShardingStrategy;

import java.util.Collection;
import java.util.List;

public class GoodsStandShardingAlgorithm implements RangeShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        return null;
    }
}
