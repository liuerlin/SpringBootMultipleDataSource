package com.doublesource.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "dbOneDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource1") // application.yml 中对应属性的前缀
    public DataSource dbOneDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dbTwoDataSource")
    @ConfigurationProperties(prefix = "datasource2") // application.yml 中对应属性的前缀
    public DataSource dbTwoDataSource() {

        return DataSourceBuilder.create().build();
    }
}