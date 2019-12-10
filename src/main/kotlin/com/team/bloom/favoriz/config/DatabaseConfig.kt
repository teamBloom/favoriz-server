package com.team.bloom.favoriz.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class DatabaseConfig {

    @Autowired
    private lateinit var properties: DataSourceProperties
    @Autowired
    private lateinit var applicationContext: ApplicationContext


    @Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .driverClassName(properties.driverClassName)
            .url(properties.url)
            .username(properties.username)
            .password(properties.password)
            .build();
    }

    @Bean
    fun sqlSessionFactory(): SqlSessionFactory? {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource())
        sqlSessionFactoryBean.setMapperLocations(*applicationContext.getResources("classpath:/mapper/***.xml"))
        return sqlSessionFactoryBean.getObject()
    }

    @Bean
    fun sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}