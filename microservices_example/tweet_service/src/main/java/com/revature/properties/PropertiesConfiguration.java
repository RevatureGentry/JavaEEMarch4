package com.revature.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ HibernateProperties.class })
public class PropertiesConfiguration {
}
