package ru.foodbooking.foodws.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
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
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String mailUsername;
    @Value("${spring.mail.password}")
    private String mailPassword;
    @Value("${spring.mail.port}")
    private Long mailPort;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private Boolean enable;
    @Value("${application.accessToken}")
    private String accessToken;

}
