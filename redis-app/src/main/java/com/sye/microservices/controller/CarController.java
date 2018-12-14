package com.sye.microservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sye.microservices.domain.Car;
import com.sye.microservices.repository.CarRepository;

@Controller
@RequestMapping("/")
public class CarController {

	@Autowired
	CarRepository carRepository;
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/cars")
	public @ResponseBody Map<Object, Object> cars() {
		return redisTemplate.opsForHash().entries("Car");
	}

	@RequestMapping("/values")
	public @ResponseBody Map<String, String> findAll() {
		 Map<String, String> map = new HashMap<String, String>();
		carRepository.findAll().forEach(car -> map.put(car.getId(), car.getName()));
		return map;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(
        @RequestParam String key,
        @RequestParam String value) {
        
        Car car = new Car(key, value);
        
        carRepository.save(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestParam String key) {
		carRepository.deleteById(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
