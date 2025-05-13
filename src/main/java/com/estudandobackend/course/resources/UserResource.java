package com.estudandobackend.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandobackend.course.entities.User;
import com.estudandobackend.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
    @GetMapping  // responde a requisicao do tipo GET do HTTP
	public ResponseEntity<List<User>> findAll() {  // Corpo da resposta vai ser uma lista de usuarios
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);  // Body -> conteudo da resposta, no caso o objeto list no qual contem lista de users
	}
    
    @GetMapping(value = "/{id}")  // Indica que a requisicao vai aceitar um id dentro da URL
    public ResponseEntity<User> findById(@PathVariable Long id) {  // Para aceitar o id e considera-lo como parametro que chegara na URL
    	User obj = service.findById(id);
    	
    	return ResponseEntity.ok().body(obj);
    }
}
