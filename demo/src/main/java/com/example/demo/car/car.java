package com.example.demo.car;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table


public class car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )


    private Long id;
    private String title;
    private String fuelType;


    private Integer price;
    private String isNew;
    private Integer mileage;
    private LocalDate firstRegistration;

    public car() {
    }

    public car(Long id,
                String title,
                String fuelType,
                Integer price,
                String isNew,
                Integer mileage,
                LocalDate firstRegistration) {
        this.id = id;
        this.title = title;
        this.fuelType = fuelType;
        this.price = price;
        this.isNew = isNew;
        this.mileage = mileage;
        this.firstRegistration = firstRegistration;
    }

    public car(
               String title,
               String fuelType,
               Integer price,
               String isNew,
               Integer mileage,
               LocalDate firstRegistration) {

        this.title = title;
        this.fuelType = fuelType;
        this.price = price;
        this.isNew = isNew;
        this.mileage = mileage;
        this.firstRegistration = firstRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public LocalDate getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(LocalDate firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", price=" + price +
                ", isNew='" + isNew + '\'' +
                ", mileage=" + mileage +
                ", firstRegistration=" + firstRegistration +
                '}';
    }
}
