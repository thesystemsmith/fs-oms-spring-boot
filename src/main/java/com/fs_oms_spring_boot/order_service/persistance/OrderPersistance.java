package com.fs_oms_spring_boot.order_service.persistance;

import com.fs_oms_spring_boot.order_service.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //marks this as a database layer component
public interface OrderPersistance extends JpaRepository<Order, Long> {
    //extending helps you access crud on springboot for free
    // Order - our entity
    // Long - type of [pk]
}
