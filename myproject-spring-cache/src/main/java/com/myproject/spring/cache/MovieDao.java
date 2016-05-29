package com.myproject.spring.cache;

public interface MovieDao{
	
	Movie findByDirector(String name);
	
}