package com.example.springbootsharingjdbc.demo.controller;

import com.example.springbootsharingjdbc.demo.mapper.GoodsMapper;
import com.example.springbootsharingjdbc.demo.mapper.UsersMapper;
import com.example.springbootsharingjdbc.demo.model.Goods;
import com.example.springbootsharingjdbc.demo.model.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyang
 * @date 2019/1/29
 */
@RestController
public class GoodsController {

  /* @Autowired
    private KeyGenerator keyGenerator;*/

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UsersMapper usersMapper;

    @GetMapping("save")
    public String save(){
        for(int i= 1 ; i <= 40 ; i ++){
            Goods goods = new Goods();
            goods.setGoodsId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            goodsMapper.insertSelective(goods);
        }
        return "success";
    }

    @GetMapping("saveUsers")
    public String saveUsers(){
        for(int i= 1 ; i <= 40 ; i ++){
            Users users = new Users();
            users.setId((long) i);
            users.setName( "shangpin" + i);
            usersMapper.insertSelective(users);
        }
        return "success";
    }

    @GetMapping("select")
    public String select(){
        return goodsMapper.selectAll().toString();
    }

    @GetMapping("delete")
    public void delete(){
        goodsMapper.deleteAll();
    }

    @GetMapping("query1")
    public Object query1(){
        return goodsMapper.findAllByGoodsIdBetween(10L, 30L);
    }

    @GetMapping("query2")
    public Object query2(){
        List<Long> goodsIds = new ArrayList<>();
        goodsIds.add(10L);
        goodsIds.add(15L);
        goodsIds.add(20L);
        goodsIds.add(25L);
        return goodsMapper.findAllByGoodsIdIn(goodsIds);
    }

    @GetMapping("selectByGoodsName")
    public Object selectByGoodsName(){
        Goods goods = new Goods();
        goods.setGoodsName("shangpin30");
        goods.setGoodsId(30L);
        return goodsMapper.selectByGoodsName(goods);
    }

    @GetMapping("selectByUserName")
    public Object selectByUserName(){
       Users user = new Users();
        user.setName("shangpin5");
        return usersMapper.selectByUserName(user);
    }

    @RequestMapping("selectByPage")
    public PageInfo selectByPage(){
        PageHelper.startPage(2,2);
        return new PageInfo(goodsMapper.selectByParams());
    }
}
