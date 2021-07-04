package com.hotelmanagement.hotelsystem.service;

import com.hotelmanagement.hotelsystem.dao.MealDao;
import com.hotelmanagement.hotelsystem.entity.MealDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealDao mealDao;

    public MealDetails enterMealDetails(MealDetails mealDetails) {
       return mealDao.save(mealDetails);
    }

    public List<MealDetails> showMealDetails() {
        return mealDao.findAll();
    }
}
