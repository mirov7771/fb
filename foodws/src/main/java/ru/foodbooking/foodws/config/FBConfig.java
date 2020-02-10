package ru.foodbooking.foodws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FBConfig {

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.jpa.database-platform}")
    private String databasePlatform;
    @Value("${spring.jpa.show-sql}")
    private Boolean showSql;
    @Value("${spring.jpa.generate-ddl}")
    private Boolean generateDdl;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;
    @Value("${spring.jpa.hibernate.naming.physical-strategy}")
    private String physicalStrategy;
    @Value("${spring.sms.login}")
    private String smsLogin;
    @Value("${spring.sms.password}")
    private String smsPassword;
    @Value("${spring.sms.url}")
    private String smsUrl;

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

    public String getSmsLogin() {
        return smsLogin;
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public String getSmsUrl() {
        return smsUrl;
    }
}
