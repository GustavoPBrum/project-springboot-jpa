package com.estudandobackend.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudandobackend.course.entities.User;
import com.estudandobackend.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
    @GetMapping  // responde a requisicao do tipo GET do HTTP, serve para recuperar dados do banco de dados
	public ResponseEntity<List<User>> findAll() {  // Corpo da resposta vai ser uma lista de usuarios
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);  // Body -> conteudo da resposta, no caso o objeto list no qual contem lista de users
	}
    
    @GetMapping(value = "/{id}")  // Indica que a requisicao vai aceitar um id dentro da URL
    public ResponseEntity<User> findById(@PathVariable Long id) {  // Para aceitar o id e considera-lo como parametro que chegara na URL
    	User obj = service.findById(id);
    	
    	return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {  // Obj chegara no modo JSON na requisicao e sera deserializado para um obj User
    	obj = service.insert(obj);								 // Sendo possivel com esta Anotation
    	
    	// Padrao HTTP para retorno 201tem que ter umm cabecalho chamado Location com o endereco do novo recurso inserido
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	return ResponseEntity.created(uri).body(obj); 
    }

    // Quando vamos deletar, passamos o Id
    @DeleteMapping(value = "/{id}")   // Tipo void pois nao tera retorno nenhum do HTTP
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	service.delete(id);
    	return ResponseEntity.noContent().build();   // noContent retorna uma resposta vazia e trata ja do codigo HTTP 204 (resposta sem conteudo)
    }
}
