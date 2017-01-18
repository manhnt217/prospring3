package com.apress.prospring3.service;

import java.util.List;

import com.apress.prospring3.domain.Car;

public interface CarService {

	public List<Car> findAll();

	public Car save(Car car);

	public void updateCarAgeJob();
}
