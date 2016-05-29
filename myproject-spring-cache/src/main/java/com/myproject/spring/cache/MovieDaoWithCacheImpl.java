package com.myproject.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("movieDaoWithCache")
public class MovieDaoWithCacheImpl implements MovieDao {

	//This "movieFindCache" is delcares in ehcache.xml
	@Cacheable(value="movieFindCache", key="#name")
	public Movie findByDirector(String name) {
		slowQuery(2000L);
		System.out.println("findByDirector is running...");
		return new Movie(1, "film", "director");
	}

	private void slowQuery(long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}
