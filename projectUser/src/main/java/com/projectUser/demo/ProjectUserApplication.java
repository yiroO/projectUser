package com.projectUser.demo;

import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
@ComponentScan
@EnableAutoConfiguration 
@SpringBootApplication
public class ProjectUserApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectUserApplication.class, args);
		
	}
	
    @Bean
    ServletContextTemplateResolver templateResolver(final ServletContext servletContext){
        ServletContextTemplateResolver resolver=new ServletContextTemplateResolver(servletContext);
        resolver.setSuffix(".html");
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

    @Bean
    SpringTemplateEngine engine(){
         SpringTemplateEngine engine=new SpringTemplateEngine();
         engine.setTemplateResolver(templateResolver(null));
         return engine;
    }

    @Bean
    ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(engine());
        return viewResolver;
    } 

	

}
