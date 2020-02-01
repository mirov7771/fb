package ru.foodbooking.foodws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
public class FoodwsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FoodwsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FoodwsApplication.class);
	}

	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			String beanNamesString = String.join("\n",beanNames);
		};
	}
}
