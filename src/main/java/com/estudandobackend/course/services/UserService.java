package com.estudandobackend.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudandobackend.course.entities.User;
import com.estudandobackend.course.repositories.UserRepository;
import com.estudandobackend.course.services.exceptions.DatabaseException;
import com.estudandobackend.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service  // Registrando como um componente Spring para ser automaticamente injetadoe deixando mais semanticamente correto e especifico
public class UserService {

	@Autowired  // O servico faz a chamada com o banco de dados (UserRepository)
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();  // Operacao padrao ja do UserRepository padrao do Spring
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		 
		// A operacao 'get' do optional vai retornar o objeto do tipo entre <> (no caso User) que estiver dentro de *obj*
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));  // Tenta fazer o get, caso contrario, lanca a excecao definida
	}
	
	public User insert(User obj) {  // Retornar o usuario salvo
		return repository.save(obj);  // Por padrao, o save ja retorna o objeto salvo
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = findById(id); // Deixa nosso obj monitorado pelo JPA para depois realizarmos operacoes com o banco de dados
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
