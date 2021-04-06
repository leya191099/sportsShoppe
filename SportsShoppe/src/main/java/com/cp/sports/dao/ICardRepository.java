package com.cp.sports.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.Entity.Card;
/**********
 * @author Pranathi Boyina
 * Description : It is a card repository interface that extends JPA repository 
 *               that contains inbuilt methods for various operations
 *Version 1.0 
 *Created Date 23-March-2021
 **********/
public interface ICardRepository extends JpaRepository<Card,Long > {

}
