package com.estudandobackend.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandobackend.course.entities.User;
import com.estudandobackend.course.repositories.UserRepository;

@Service  // Registrando como um componente Spring para ser automaticamente injetadoe deixando mais semanticamente correto e especifico
public class UserService {

	@Autowired  // O servico faz a chamada com o banco de dados (UserRepository)
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();  // Operacao padrao ja do UserRepository padrao do Spring
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		 
		return obj.get();  // A operacao 'get' do optional vai retornar o objeto do tipo entre <> (no caso User) que estiver dentro de *obj*
	}
	
	public User insert(User obj) {  // Retornar o usuario salvo
		return repository.save(obj);  // Por padrao, o save ja retorna o objeto salvo
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
