package com.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
       // SpringApplication.run(Application.class, args);
        System.out.println("______________Application Started________________");

        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server successfully");

        //store data in redis list
        jedis.lpush("list1", "1");
        jedis.lpush("list1", "2");
        jedis.lpush("list1", "3");
        // Get the stored data and print it
        List<String> list = jedis.lrange("list1", 0, 10000);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis:: " + list.get(i));
        }

    }
}
