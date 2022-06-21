package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "car/adverts")


public class carController {

    private final carService carService;

    @Autowired
    public carController(com.example.demo.car.carService carService) {
        this.carService = carService;
    }

  @GetMapping
    public List<car> getCars() {
    return carService.getCars();
  }

//   @GetMapping
//   public List<car> getCars(@RequestParam Optional<String> sortBy) {
//      return carService.findAll(Sort.Direction.ASC, sortBy.orElse("carId"));
//
//  }



    @GetMapping(path = "{carId}")
    public car getCar (@PathVariable("carId") Long carId) {
       return carService.getSingleCar(carId);

    }


   @PostMapping
    public car registerNewCar (@Validated @RequestBody car car){
        return carService.addNewCar(car);
    }


    @DeleteMapping(path = "{carId}")
    public void deleteCar(@PathVariable("carId") Long carId){
        carService.deleteCar(carId);
    }

    @PutMapping(path = "{carId}")
    public car updateCar(@PathVariable Long carId, @RequestBody car car){
        car.setId(carId);
        return carService.updateCar(car);
    }


}
