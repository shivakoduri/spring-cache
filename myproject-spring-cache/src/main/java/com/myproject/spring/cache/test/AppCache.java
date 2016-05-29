package com.myproject.spring.cache.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.spring.cache.MovieDao;

public class AppCache {
	
	private static final Logger log = LoggerFactory.getLogger(AppCache.class);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCache.class);
	    MovieDao obj = (MovieDao) context.getBean("movieDaoWithCache");
	    
	    log.debug("Result : {}", obj.findByDirector("dummy"));
	    log.debug("Result : {}", obj.findByDirector("dummy"));
	    log.debug("Result : {}", obj.findByDirector("dummy"));
	    
	    //shut down the Spring context.
	    ((ConfigurableApplicationContext)context).close();
	    /**
	     * In non-web application, you need to shut down the Spring context manually, 
	     * so that Ehcache got chance to shut down as well, otherwise Ehcache manager will hang there
	     */
	    

	}

}
/*findByDirector is running...
2016-05-29 23:04:03 [main] DEBUG c.m.spring.cache.test.AppCache - Result : Movie [id=1, name=film, directory=director]
2016-05-29 23:04:03 [main] DEBUG c.m.spring.cache.test.AppCache - Result : Movie [id=1, name=film, directory=director]
2016-05-29 23:04:03 [main] DEBUG c.m.spring.cache.test.AppCache - Result : Movie [id=1, name=film, directory=director]*/