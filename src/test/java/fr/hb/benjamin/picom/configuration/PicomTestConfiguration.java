//package fr.hb.benjamin.picom.configuration;
//
//import java.util.Properties;
//
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//@SpringBootConfiguration
//@ComponentScan(basePackages = "fr.hb.benjamin.picom")
//@EnableJpaRepositories(basePackages = "fr.hb.benjamin.picom.dao", entityManagerFactoryRef = "entityManagerFactory")
//public class PicomTestConfiguration {
//
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		DataSource dataSource = new DataSource();
//		dataSource.setUsername("root");
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:mem:picom");
//		dataSource.setValidationQuery("SELECT 1");
//		dataSource.setValidationInterval(34000);
//		dataSource.setTestOnBorrow(true);
//		return dataSource;
//	}
//	
//	@Bean("entityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setDataSource(getDataSource());
//		entityManagerFactoryBean.setPersistenceUnitName("entityManagerFactory");
//		entityManagerFactoryBean.setPackagesToScan("fr.hb.benjamin.picom.business");
//		Properties jpaProperties = new Properties();
//		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
//		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//		jpaProperties.put("hibernate.show_sql", "true");
//		entityManagerFactoryBean.setJpaProperties(jpaProperties);
//		
//		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter );
//		return entityManagerFactoryBean;
//	}
//
//	@Bean("transactionManager")
//	public JpaTransactionManager getTransactionManager() {
//		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//		jpaTransactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
//		return jpaTransactionManager;
//	}
//	
//}
