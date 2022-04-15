package com.paradz3033.controller;
import com.paradz3033.dao.MovieDao;
import com.paradz3033.dao.MovieDaoImpl;
import com.paradz3033.dao.ScreeningDao;
import com.paradz3033.dao.ScreeningDaoImpl;
import com.paradz3033.service.MovieService;
import com.paradz3033.service.MovieServiceImpl;
import com.paradz3033.service.ScreeningService;
import com.paradz3033.service.ScreeningServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@EnableWebMvc
@ComponentScan(basePackages = "com.paradz3033")
@Configuration
public class ApplicationContextConfiguration implements WebMvcConfigurer {

    @Bean(name = "viewResolver")
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public MovieDao movieDao(){
        MovieDaoImpl movieDao = new MovieDaoImpl();
        return movieDao;
    }

    @Bean
    public MovieService movieService(){
        MovieServiceImpl movieService = new MovieServiceImpl();
        return movieService;
    }

    @Bean
    public ScreeningDao screeningDao(){
        ScreeningDaoImpl screeningDao = new ScreeningDaoImpl();
        return screeningDao;
    }

    @Bean
    public ScreeningService screeningService(){
        ScreeningServiceImpl screeningService = new ScreeningServiceImpl();
        return screeningService;
    }

}
