package com.ems.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistencyConfig.class)
@ComponentScan(basePackages = { "com.ems.service" })
public class RootConfig {

}
