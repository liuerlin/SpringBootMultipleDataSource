package com.doublesource.demo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：https://www.sojson.com/blog/  <p>
 * <p>
 * 说明：<br/>
 *
 *  如果有多个就直接创建多个，SqlSessionFactory && SqlSessionTemplate 创建
 * <p>
 *
 * 区分　责任人　日期　　　　<br/>
 * 创建　周柏成　 2018年05月01日22:33:18 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
@Slf4j
public class MybatisConfig {


    /**
     * 第一个数据库 SqlSessionFactory && SqlSessionTemplate 创建
     */
    @Configuration
    @MapperScan(basePackages = {"com.doublesource.demo.dataSource_1.mapper"},
            sqlSessionFactoryRef = "sqlSessionFactoryOne",
            sqlSessionTemplateRef = "sqlSessionTemplateOne")
    public static  class DBOne{
        @Resource
        DataSource dbOneDataSource;


        @Bean
        public SqlSessionFactory sqlSessionFactoryOne() throws Exception {
            log.info("sqlSessionFactoryOne 创建成功。");
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dbOneDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/one/*.xml"));
            return factoryBean.getObject();

        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplateOne() throws Exception {
            SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryOne()); // 使用上面配置的Factory
            return template;
        }
    }

    /**
     * 第二个数据库 SqlSessionFactory && SqlSessionTemplate 创建
     */
    @Configuration
    @MapperScan(basePackages = {"com.doublesource.demo.dataSource_2.mapper"},
            sqlSessionFactoryRef = "sqlSessionFactoryTwo",
            sqlSessionTemplateRef ="sqlSessionTemplateTwo" )
    public static class DBTwo{
        @Resource
        DataSource dbTwoDataSource;


        @Bean
        public SqlSessionFactory sqlSessionFactoryTwo() throws Exception {
            log.info("sqlSessionFactoryTwo 创建成功。");
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dbTwoDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/two/*.xml"));
            return factoryBean.getObject();

        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplateTwo() throws Exception {
            SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTwo()); // 使用上面配置的Factory
            return template;
        }
    }
}
