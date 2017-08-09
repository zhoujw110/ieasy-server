package com.baayso.springboot.config.mybatis;

import java.util.Properties;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baayso.commons.mybatis.mapper.CommonMapper;
import com.baayso.springboot.Application;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;


/**
 * 集成通用Mapper。
 *
 * @since 1.0.0
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        Properties properties = new Properties();
        properties.setProperty("mappers", CommonMapper.class.getName());
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(ClassUtils.getPackageName(Application.class) + ".**.dao");
        mapperScannerConfigurer.setMarkerInterface(tk.mybatis.mapper.common.Mapper.class);
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }

}
