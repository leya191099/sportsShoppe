package com.cp.sports.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.sports.Entity.Orders;
@Repository
public interface IOrderRepository extends JpaRepository<Orders,Long>{
//	ll
}
