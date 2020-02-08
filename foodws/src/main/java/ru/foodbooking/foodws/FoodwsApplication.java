package ru.foodbooking.foodws;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
public class FoodwsApplication extends SpringBootServletInitializer {

	private static Logger LOG = Logger.getLogger(FoodwsApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FoodwsApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FoodwsApplication.class);
	}

	public void onStartup(ServletContext servletContext) throws ServletException {
		LogManager.resetConfiguration();
		PropertyConfigurator.configureAndWatch("/opt/foodbooking/logs/log4j.properties");
		Runtime.getRuntime().addShutdownHook(new Thread(LogManager::shutdown));
		LOG.info("ru.foodbooking.foodws.FoodwsApplication.onStartup(1): servletContext="+servletContext);
		super.onStartup(servletContext);
	}

	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			String beanNamesString = String.join("\n",beanNames);
			LOG.info("Let's inspect the beans provided by Spring Boot:\n" + beanNamesString);
		};
	}
}
