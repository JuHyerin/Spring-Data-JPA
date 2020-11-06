package com.innilabs.inniboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.innilabs.inniboard.repository")
public class JpaConfig {

}
