package ru.itis.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableAspectJAutoProxy
@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "ru.itis.demo.repository")
@PropertySource("classpath:application.properties")
public class Config implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Css resource.
        registry.addResourceHandler("/static/**") //
                .addResourceLocations("classpath:static/").setCachePeriod(31556926);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/templates/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        resolver.setRedirectContextRelative(false);
//        return resolver;
//    }

//  @Bean
//  public DataSource dataSource() {
//    return new HikariDataSource(hikariConfig());
//  }

//  @Bean
//  public HikariConfig hikariConfig() {
//    HikariConfig hikariConfig = new HikariConfig();
//    hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
//    hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getProperty("db.hikari.max-pool-size")));
//    hikariConfig.setUsername(environment.getProperty("db.username"));
//    hikariConfig.setPassword(environment.getProperty("db.password"));
//    hikariConfig.setDriverClassName(environment.getProperty("db.driver.classname"));
//    return hikariConfig;
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//    // создаем адаптер, который позволит Hibernate работать с Spring Data Jpa
//    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//    hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
//    // создали фабрику EntityManager как Spring-бин
//    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//    entityManagerFactory.setDataSource(dataSource());
//    entityManagerFactory.setPackagesToScan("ru.itis.demo.mo");
//    entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
//    entityManagerFactory.setJpaProperties(additionalProperties());
//    return entityManagerFactory;
//  }
//
//  private Properties additionalProperties() {
//    Properties properties = new Properties();
//    properties.setProperty("hibernate.hbm2ddl.auto", "update");
//    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
//    properties.setProperty("hibernate.show_sql", "true");
//    return properties;
//  }
//
//  @Bean
//  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(entityManagerFactory);
//
//    return transactionManager;
//  }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages");
        return resourceBundleMessageSource;
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("lang");
        return localeResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
        res.setBasenames("classpath:i18n/messages", "classpath:i18n/validation");
        res.setCacheSeconds(0);
        res.setDefaultEncoding("UTF-8");
        res.setUseCodeAsDefaultMessage(false);
        return res;
    }

}
