package com.estudo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.course.entities.OrderItem;
import com.estudo.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}