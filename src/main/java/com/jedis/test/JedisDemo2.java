package com.jedis.test;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;

/**
 *连接池的方式连接
 */
public class JedisDemo2 {
    public static void main(String[] args) {
        //获取连接池的配置
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(30);
        //设置最大空闲连接数
        config.setMaxIdle(10);
        //获得连接池
        JedisPool jedisPool=new JedisPool(config,"192.168.21.195",6379);
        //获得核心对象
        Jedis jedis=null;
        try {
            //通过连接池获得连接
            jedis=jedisPool.getResource();
            //设置数据
            jedis.set("name","张三");
            //获取数据
            String value = jedis.get("name");
            System.out.println("name对应的value:"+value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null){
                jedis.close();
            }
            if (jedisPool!=null){
                jedisPool.close();
            }
        }
    }

}
