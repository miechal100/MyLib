package com.example.mylib.MyLib.customer;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@ComponentScan(basePackages = {"com.example.mylib.MyLib.customer"})
@Configuration
public class MongoTestConfiguration {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(new MongoClient("localhost"), "findAl");
    }

}
