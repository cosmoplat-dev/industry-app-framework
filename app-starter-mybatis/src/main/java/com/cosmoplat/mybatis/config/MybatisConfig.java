package com.cosmoplat.mybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 27279
 */
@Configuration
@PropertySource(value = { "classpath:application-mybatis.yml",
}, encoding = "utf-8",factory = YamlConfigFactory.class)
public class MybatisConfig {
}
