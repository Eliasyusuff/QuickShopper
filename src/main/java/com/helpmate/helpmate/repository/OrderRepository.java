package com.helpmate.helpmate.repository;

import com.helpmate.helpmate.entity.Order;
import com.helpmate.helpmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
   List<Order> findAllByUserOrderByCreatedDateDesc(User user);

    Optional<Order> findOrderById (Long Id);
    Boolean existsOrderById (Long Id);
}
