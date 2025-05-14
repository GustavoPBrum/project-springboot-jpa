package com.estudandobackend.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudandobackend.course.entities.Category;
import com.estudandobackend.course.entities.Order;
import com.estudandobackend.course.entities.Product;
import com.estudandobackend.course.entities.User;
import com.estudandobackend.course.entities.enums.OrderStatus;
import com.estudandobackend.course.repositories.CategoryRepository;
import com.estudandobackend.course.repositories.OrderRepository;
import com.estudandobackend.course.repositories.ProductRepository;
import com.estudandobackend.course.repositories.UserRepository;

@Configuration
@Profile("test") // Tem de ser igual ao nome posto no arquivo application.proprieties que o Spring usara essa configuracao apenas no perfil de teste
public class TestConfig implements CommandLineRunner {  // Para executar tudo que estiver dentro deste metodo (Run)
	
	@Autowired  // Com isso o spring vai resolver esta dependencia e associar uma instancia de userRepository aqui dentro
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
@Override
public void run(String... args) throws Exception {
	Category cat1 = new Category(null, "Electronics");
	Category cat2 = new Category(null, "Books");
	Category cat3 = new Category(null, "Computers");
	
	Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
	Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
	Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
	Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
	Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
	
	categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));	
	
	// Vamos fazer associacao no paradigma OO e o JPA fara automaticamente a associacao pro Banco de Dados em paradigma Relacional
	p1.getCategories().add(cat2);
	p2.getCategories().add(cat1);
	p2.getCategories().add(cat3);
	p3.getCategories().add(cat3);
	p4.getCategories().add(cat3);
	p5.getCategories().add(cat2);
	
	productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));  // Salva novamente as alteracoes/associacoes feitas
	
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
	Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMMENT, u2);
	Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1); 
	
	userRepository.saveAll(Arrays.asList(u1, u2));
	orderRepository.saveAll(Arrays.asList(o1, o2, o3));
} 
}
