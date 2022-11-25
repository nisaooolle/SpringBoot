package com.data.tokoonline.repository;

import com.data.tokoonline.model.Order;
import com.data.tokoonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders where pemilik = :pemilik", nativeQuery = true)
    Optional<Order> findByPemilik(String pemilik);
}
