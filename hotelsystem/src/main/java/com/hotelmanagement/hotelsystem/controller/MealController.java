package com.hotelmanagement.hotelsystem.controller;

import com.hotelmanagement.hotelsystem.entity.MealDetails;
import com.hotelmanagement.hotelsystem.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping("/enter-meal-details")
    public MealDetails enterMealDetails(@RequestBody MealDetails mealDetails){
       return mealService.enterMealDetails(mealDetails);
    }

    @GetMapping("/show-meal-details")
    public List<MealDetails> showMealDetails(){

        return mealService.showMealDetails();
    }
}
