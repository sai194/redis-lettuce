package com.sye.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sye.microservices.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {

}
