package com.cp.sports.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.Entity.Address;
/**********
 * @author G. Jhansi 
 * Description It is a  repository interface that extends JPA repository 
 *                        that contains inbuilt methods for various operations
 *Version 1.0 
 *Created Date 23-March-2021
 **********/

public interface IAddressRepository extends JpaRepository<Address, String>{

}
