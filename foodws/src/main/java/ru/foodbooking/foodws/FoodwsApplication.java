package ru.foodbooking.foodws;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@Slf4j
public class FoodwsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FoodwsApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FoodwsApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LogManager.resetConfiguration();
		PropertyConfigurator.configureAndWatch("log4j.properties");
		Runtime.getRuntime().addShutdownHook(new Thread(LogManager::shutdown));
		log.info("ru.foodbooking.foodws.FoodwsApplication.onStartup(1): servletContext="+servletContext);
		System.out.println("ru.foodbooking.foodws.FoodwsApplication.onStartup(1): servletContext="+servletContext);
		super.onStartup(servletContext);
	}

}
