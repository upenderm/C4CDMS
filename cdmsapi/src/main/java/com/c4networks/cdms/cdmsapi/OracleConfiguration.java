package com.c4networks.cdms.cdmsapi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ComponentScan(basePackages = { "com.c4networks.cdms.cdmsapi.controller", "com.c4networks.cdms.cdmsapi.service, com.c4networks.cdms.cdmsapi.entity" })
@EnableTransactionManagement
@EnableJpaRepositories("com.c4networks.cdms.cdmsapi.repository")
//@EntityScan("com.c4networks.cdms.cdmsapi.entity.*")
public class OracleConfiguration {

	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Bean
	public DataSource dataSource() throws Exception {
		OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(true);
//        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
	}
	
//	@Bean
//    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dataSource);
//
//        return dataSourceTransactionManager;
//    }
//	
//	@Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("ru.testproject.hibernate.*");
//        factory.setDataSource(dataSource());
//        factory.afterPropertiesSet();
//        factory.setPersistenceUnitName("test");
//        return factory;
//    }
}
