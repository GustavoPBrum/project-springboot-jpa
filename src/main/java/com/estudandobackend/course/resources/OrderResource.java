package com.estudandobackend.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandobackend.course.entities.Order;
import com.estudandobackend.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
    @GetMapping  // responde a requisicao do tipo GET do HTTP
	public ResponseEntity<List<Order>> findAll() {  // Corpo da resposta vai ser uma lista de usuarios
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);  // Body -> conteudo da resposta, no caso o objeto list no qual contem lista de Orders
	}
    
    @GetMapping(value = "/{id}")  // Indica que a requisicao vai aceitar um id dentro da URL
    public ResponseEntity<Order> findById(@PathVariable Long id) {  // Para aceitar o id e considera-lo como parametro que chegara na URL
    	Order obj = service.findById(id);
    	
    	return ResponseEntity.ok().body(obj);
    }
}
