package com.estudandobackend.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandobackend.course.entities.Order;

// Spring Data JPA ja tem uma implementacao padrao para esse caso. Definindo o JPA generic com a entidade e o tipo do ID da entidade ja tera uma implementacao padrao
// Para este tipo especifico
public interface OrderRepository extends JpaRepository<Order, Long> {

}
