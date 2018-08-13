package com.anjie.blogserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //开启缓存的支持
public class BlogserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogserverApplication.class, args);
	}
}
