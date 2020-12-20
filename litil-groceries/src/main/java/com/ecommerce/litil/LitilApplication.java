package com.ecommerce.litil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EntityScan(basePackages = {"com.ecommerce.litil.entity"})
@EnableJpaRepositories(basePackages = "com.ecommerce.litil.repository")
@Import(value = {RestTemplate.class})
public class LitilApplication {

	private static final Logger logger = LoggerFactory.getLogger(LitilApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LitilApplication.class, args);
	}


}
