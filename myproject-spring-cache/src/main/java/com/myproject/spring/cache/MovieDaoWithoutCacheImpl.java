package com.myproject.spring.cache;

import org.springframework.stereotype.Repository;

@Repository("movieDaoWithOutCache")
public class MovieDaoWithoutCacheImpl implements MovieDao {

	// each call will delay 2 seconds, simulate the slow query call
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