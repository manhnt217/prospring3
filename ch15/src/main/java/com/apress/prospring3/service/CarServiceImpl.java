package com.apress.prospring3.service;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.domain.Car;
import com.apress.prospring3.repository.CarRepository;
import com.google.common.collect.Lists;

@Service("carService")
@Transactional
@Repository
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

	@Transactional(readOnly = true)
	public List<Car> findAll() {

		return Lists.newArrayList(carRepository.findAll());
	}

	public Car save(Car car) {

		return carRepository.save(car);
	}

	public void updateCarAgeJob() {

		List<Car> cars = findAll();
		DateTime currentDateTime = DateTime.now();
		int age;

		logger.info("\nUpdate job started");

		for (Car car : cars) {
			int oldAge = car.getAge();
			age = new Period(car.getManufactureDate(), currentDateTime, PeriodType.years()).getYears();
			car.setAge(age);
			save(car);
			logger.info("Old age: " + oldAge + " New age: " + age);
		}

		logger.info("Update job succeeded\n");
	}
}
