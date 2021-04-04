package com.cp.sports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cp.sports"})
public class SportsShoppeOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsShoppeOrderApplication.class, args);
	}

}
