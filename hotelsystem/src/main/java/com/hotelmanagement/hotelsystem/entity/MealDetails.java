package com.hotelmanagement.hotelsystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MealDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long mealId;
    private String mealType;
    private Long mealPrice;

    public MealDetails(String mealType, Long mealPrice) {
        this.mealType = mealType;
        this.mealPrice = mealPrice;
    }
}
