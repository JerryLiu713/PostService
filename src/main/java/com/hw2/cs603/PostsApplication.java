package com.hw2.cs603;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Driver method for posts service.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PostsApplication {

    public static void main(String[] args) {

        SpringApplication.run(PostsApplication.class, args);

        System.setProperty("spring.config.name", "application");
    }

}
