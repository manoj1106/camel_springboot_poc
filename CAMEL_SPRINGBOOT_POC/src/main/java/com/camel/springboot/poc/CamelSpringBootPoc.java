/**
 * 
 */
package com.camel.springboot.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Manoj Patel
 *
 */
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
@ImportResource("classpath:config/spring/spring-config.xml")
public class CamelSpringBootPoc {

	private static final Logger log = LoggerFactory.getLogger(CamelSpringBootPoc.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("**************** Starting Application ****************");
		ApplicationContext context = SpringApplication.run(CamelSpringBootPoc.class, args);
		log.info("**************** Ending Application ****************");
	}

}
