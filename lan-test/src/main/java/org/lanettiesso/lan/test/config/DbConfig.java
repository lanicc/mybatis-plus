package org.lanettiesso.lan.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * @author lan
 * @date 2020/9/22
 */
@Configuration
public class DbConfig {

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.microsoft.sqlserver.jdbc.SQLServerDriver.class);
        dataSource.setUrl("jdbc:sqlserver://10.20.3.1:1433;DatabaseName=HEQS");
        dataSource.setUsername("sa");
        dataSource.setPassword("hjk123");

        return dataSource;
    }
}
