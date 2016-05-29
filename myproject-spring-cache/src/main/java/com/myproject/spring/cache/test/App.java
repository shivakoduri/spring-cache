/**
 * 
 */
package com.myproject.spring.cache.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.spring.cache.MovieDao;

/**
 * @author shiva koduri
 *
 */
public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MovieDao dao = (MovieDao)context.getBean("movieDaoWithOutCache");
		
		log.debug("Result : {}", dao.findByDirector("dummy"));
		log.debug("Result : {}", dao.findByDirector("dummy"));
		log.debug("Result : {}", dao.findByDirector("dummy"));
	}

}

/*findByDirector is running...
2016-05-29 23:04:48 [main] DEBUG com.myproject.spring.cache.test.App - Result : Movie [id=1, name=film, directory=director]
findByDirector is running...
2016-05-29 23:04:50 [main] DEBUG com.myproject.spring.cache.test.App - Result : Movie [id=1, name=film, directory=director]
findByDirector is running...
2016-05-29 23:04:52 [main] DEBUG com.myproject.spring.cache.test.App - Result : Movie [id=1, name=film, directory=director]*/