package com.cp.sports.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.Entity.Customer;
public interface ICustomerRepository extends JpaRepository<Customer,String>{

}
