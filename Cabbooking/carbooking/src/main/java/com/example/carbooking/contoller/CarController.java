package com.example.carbooking.contoller;

import com.example.carbooking.entities.CarEntity;
import com.example.carbooking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping("/create")
    public ResponseEntity<CarEntity> create(@RequestBody CarEntity carEntity) {
        CarEntity savedEntity = carService.create(carEntity);
        return ResponseEntity.ok(savedEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(carService.getById(id));
    }
}