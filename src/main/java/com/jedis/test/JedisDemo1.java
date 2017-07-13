package com.jedis.test;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017-07-13.
 */
public class JedisDemo1 {
    /**
     * 单实例测试
     */
    public static void main(String[] args) {
        //设置IP地址和端口
        Jedis jedis=new Jedis("192.168.21.195",6379);
        //保存数据
        jedis.set("name","lu");
        //获取数据
        String value=jedis.get("name");
        System.out.println("name对应的："+value);
        //释放资源
        jedis.close();
    }
}
