package com.sye.microservices.domain;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Car")
public class Car {
	private String id;
    private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CarDomain [id=" + id + ", name=" + name + "]";
	}
	public Car(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
    
}
