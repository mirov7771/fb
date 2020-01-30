package ru.foodbooking.foodws.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    public DataSource fbDataSource(FBConfig fbConfig){
        String url = fbConfig.getUrl();
        String username = fbConfig.getUsername();
        String password = fbConfig.getPassword();
        String driver = fbConfig.getDriverClassName();
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource(url, username, password, true);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    public PlatformTransactionManager transactionManager(@Qualifier("fbDataSource") DataSource dataSource){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(dataSource);
        return  jpaTransactionManager;
    }

}
