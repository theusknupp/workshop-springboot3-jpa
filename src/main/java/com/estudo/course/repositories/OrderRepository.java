package com.estudo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
