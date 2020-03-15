package com.github.dreamyoung.mprelation.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.dreamyoung.mprelation.AutoMapper;

@Configuration
@EnableTransactionManagement
//was not registered for synchronization because synchronization is not active
//@ImportResource(locations = "classpath:transaction.xml")
public class AutoMapperConfig {
	@Bean
	public AutoMapper autoMapper(@Autowired(required = false) ApplicationContext applicationContext) {
		return new AutoMapper(applicationContext, new String[] { "com.github.dreamyoung.mprelation.demo.entity" });
	}
}
