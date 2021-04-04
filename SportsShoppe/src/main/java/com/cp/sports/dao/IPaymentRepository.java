package com.cp.sports.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.Entity.Payment;




public interface IPaymentRepository extends JpaRepository<Payment,Long> {

}
