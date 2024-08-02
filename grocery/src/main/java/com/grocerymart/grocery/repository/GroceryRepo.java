package com.grocerymart.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocerymart.grocery.model.GroceryModel;

@Repository
public interface GroceryRepo extends JpaRepository<GroceryModel,Integer> {

}
