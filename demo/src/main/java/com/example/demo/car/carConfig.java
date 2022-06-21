package com.example.demo.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class carConfig {

    @Bean
    CommandLineRunner commandLineRunner(carRepository repository){
        return args -> {
           car car1 = new car(

                    "Title for advert 88",
                    "diesel",
                    20000,
                    "false",
                    1453,
                    LocalDate.of(2014, 5, 5)
            );

           car car2 = new car(

                    "Title for advert 22",
                    "diesel",
                    40000,
                    "false",
                    2222,
                    LocalDate.of(2015, 6, 2)
            );

           repository.saveAll(
                   List.of(car1, car2)
           );


        };
    }
}
