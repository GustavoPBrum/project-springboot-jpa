package com.estudandobackend.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandobackend.course.entities.OrderItem;
import com.estudandobackend.course.entities.pk.OrderItemPK;
											
//														  <ENTIDADE, TIPO DO ***ID*** DA ENTIDADE>
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
