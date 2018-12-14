package com.sye.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sye.microservices.domain.Car;
import com.sye.microservices.repository.CarRepository;

@SpringBootApplication
public class RedisAppApplication  implements CommandLineRunner{

	@Autowired
	CarRepository carRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RedisAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Car ferrari = new Car("1","Ferrari");
		carRepository.save(ferrari);
		
		Car porsche = new Car("2","Porsche");
		carRepository.save(porsche);
		
	}
	
	
}

