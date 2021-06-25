package com.hotelmanagement.hotelsystem.dao;

import com.hotelmanagement.hotelsystem.entity.MealDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MealDao extends JpaRepository<MealDetails,Long> {

    @Query("select m from MealDetails m where m.mealId=:mealId")
    public MealDetails getMealById(@Param("mealId") Long mealId);
}
