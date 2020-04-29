package com.github.dreamyoung.mprelation.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dreamyoung.mprelation.AutoMapper;

@Configuration
public class AutoMapperConfig {
	@Bean
	public AutoMapper autoMapper() {
		return new AutoMapper(new String[] { "com.github.dreamyoung.mprelation.demo.entity",
				"com.github.dreamyoung.mprelation.demo.entity2.bean" });
	}

}
