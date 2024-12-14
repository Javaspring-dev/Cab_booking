package com.example.carbooking.service;

import com.example.carbooking.Exception_Handler.ConflictException;
import com.example.carbooking.entities.CarEntity;
import com.example.carbooking.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
     public final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarEntity create(CarEntity carEntity) {
        Optional<CarEntity> carByid = carRepository.findByCarId(carEntity.getId());
        if (carByid.isPresent()){
            throw new ConflictException("Car details already present");
        }
        return carRepository.save(carEntity);
    }

    public Object getById(Long id){
        Optional<CarEntity> FindById = carRepository.findByCarId(id);
        if (FindById.isPresent()){
            return carRepository.findByCarId(id);
        }
        throw new ConflictException("Create the car details");
    }
}