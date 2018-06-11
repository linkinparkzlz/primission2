package com.zou.primission2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan(basePackages = {"com.zou.primission2.mapper"})
public class Primission2Application {

	public static void main(String[] args) {
		SpringApplication.run(Primission2Application.class, args);
	}
}
