package com.myproject.spring.cache.test;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
@ComponentScan({"com.myproject.spring.*"})
public class AppConfigCache {
	
	@Bean
	public CacheManager cacheManager(){
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}
	
	public EhCacheManagerFactoryBean ehCacheCacheManager(){
		EhCacheManagerFactoryBean  cmfb = new EhCacheManagerFactoryBean ();
		
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		
		return cmfb;
	}
	
	

}
