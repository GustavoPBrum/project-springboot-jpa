package com.estudandobackend.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandobackend.course.entities.Order;
import com.estudandobackend.course.repositories.OrderRepository;

@Service  // Registrando como um componente Spring para ser automaticamente injetadoe deixando mais semanticamente correto e especifico
public class OrderService {

	@Autowired  // O servico faz a chamada com o banco de dados (OrderRepository)
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();  // Operacao padrao ja do OrderRepository padrao do Spring
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		 
		return obj.get();  // A operacao 'get' do optional vai retornar o objeto do tipo entre <> (no caso Order) que estiver dentro de *obj*
	}

}
