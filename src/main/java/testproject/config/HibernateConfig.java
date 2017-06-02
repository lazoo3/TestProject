package testproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"testproject.config"})
public class HibernateConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionBeanFactory(){
		LocalSessionFactoryBean sessionBeanFactory = new LocalSessionFactoryBean();
		
		sessionBeanFactory.setDataSource(dataSource());
		sessionBeanFactory.setPackagesToScan(new String[] {"testproject.model"});
		sessionBeanFactory.setHibernateProperties(hibernateProperties());
		return sessionBeanFactory;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/testdb");
		ds.setUsername("root");
		return ds;
	}
	
	private Properties hibernateProperties(){
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql","false");
		
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(s);
		return tx;
	}
}
