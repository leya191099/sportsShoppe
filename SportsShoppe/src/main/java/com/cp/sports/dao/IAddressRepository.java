package com.cp.sports.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.Entity.Address;

public interface IAddressRepository extends JpaRepository<Address, String>{

}
