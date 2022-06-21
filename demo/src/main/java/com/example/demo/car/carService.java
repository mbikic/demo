package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class carService {

    @Autowired
    private final carRepository carRepository;


    public carService(carRepository carRepository){
        this.carRepository = carRepository;
    }

  public List<car> getCars() {

     return carRepository.findAll();
 }




   public car getSingleCar (Long carId) {
       Optional<car> car=carRepository.findById(carId);
       if(car.isPresent()){
           return car.get();
       }
       throw new RuntimeException(" No car advert with given id " + carId + " was found." );

   }

    public car addNewCar(car car){

        return carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        boolean exists = carRepository.existsById(carId);
        if(!exists){
            throw new IllegalStateException(
                    " car with id " + carId + " does not exists"
            );
        }
        carRepository.deleteById(carId);

    }

   @Transactional
    public car updateCar(car  car){
        return carRepository.save(car);
   }



}
