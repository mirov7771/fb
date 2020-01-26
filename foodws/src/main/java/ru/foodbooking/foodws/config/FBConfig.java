package ru.foodbooking.foodws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FBConfig {

    @Value("${datasource.driverClassName}")
    private String driverClassName;
    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${jpa.database-platform}")
    private String databasePlatform;
    @Value("${jpa.show-sql}")
    private Boolean showSql;
    @Value("${jpa.generate-ddl}")
    private Boolean generateDdl;
    @Value("${jpa.hibernate.ddl-auto}")
    private String ddlAuto;
    @Value("${jpa.hibernate.naming.physical-strategy}")
    private String physicalStrategy;

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabasePlatform() {
        return databasePlatform;
    }

    public Boolean getShowSql() {
        return showSql;
    }

    public Boolean getGenerateDdl() {
        return generateDdl;
    }

    public String getDdlAuto() {
        return ddlAuto;
    }

    public String getPhysicalStrategy() {
        return physicalStrategy;
    }
}
