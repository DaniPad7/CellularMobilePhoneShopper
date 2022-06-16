package com.phoneshopper.mobile.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration()
public class JpaConfiguration {

    @Bean()
    public DataSource getDataSource(Environment env) {
//        Will we need an Environment bean in the bean container
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(/*env.getProperty("MYSQL_URI")simplepass1234mobilephones*/
                "jdbc:mysql://appuser:simplepass1234mobilephones@127.0.0.1:3306/mobile_phones");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("example");
        return dataSourceBuilder.build();
    }

}
