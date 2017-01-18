package com.apress.prospring3.repository;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.domain.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

}
