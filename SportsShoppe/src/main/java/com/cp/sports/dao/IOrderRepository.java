package com.cp.sports.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.sports.Entity.Orders;

@Repository
/****************************
 * @author Leya Varghese 
 * Description It is a order repository interface that extends JPA repository 
 *                        that contains inbuilt methods for various operations
 *Version 1.0 
 *Created Date 23-March-2021
 ****************************/
public interface IOrderRepository extends JpaRepository<Orders, String> {

}
