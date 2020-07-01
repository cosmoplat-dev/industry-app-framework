package com.cosmoplat.influx.config;

import com.cosmoplat.influx.util.InfluxDBUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: CRX
 * @Date: 2019/11/19
 */
@Configuration
@PropertySource(value = { "classpath:application-influx.yml",
}, encoding = "utf-8",factory = YamlConfigFactory.class)
public class InfluxDBConfig {
    @Value("${spring.influx.url}")
    private String influxDBUrl;

    @Value("${spring.influx.user}")
    private String userName;

    @Value("${spring.influx.password}")
    private String password;

    @Value("${spring.influx.database}")
    private String database;

    @Bean
    public InfluxDBUtils influxDbUtils() {
        System.out.println("--------userName-------"+userName+"--password---"+password);
        return new InfluxDBUtils(userName, password, influxDBUrl, database, "autogen");
    }

}
