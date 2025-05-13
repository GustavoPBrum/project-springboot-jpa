package com.estudandobackend.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandobackend.course.entities.Category;
import com.estudandobackend.course.repositories.CategoryRepository;

@Service  // Registrando como um componente Spring para ser automaticamente injetadoe deixando mais semanticamente correto e especifico
public class CategoryService {

	@Autowired  // O servico faz a chamada com o banco de dados (CategoryRepository)
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();  // Operacao padrao ja do CategoryRepository padrao do Spring
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		 
		return obj.get();  // A operacao 'get' do optional vai retornar o objeto do tipo entre <> (no caso 	) que estiver dentro de *obj*
	}

}
