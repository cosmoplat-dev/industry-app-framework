package com.cosmoplat.elasticsearch.config;

import com.cosmoplat.swagger.config.YamlConfigFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 27279
 */
@Configuration
@PropertySource(value = { "classpath:application-elasticsearch.yml",
}, encoding = "utf-8",factory = YamlConfigFactory.class)
public class ElasticsearchConfig {


}
