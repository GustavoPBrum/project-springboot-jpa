package com.estudandobackend.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudandobackend.course.entities.User;
import com.estudandobackend.course.repositories.UserRepository;

@Configuration
@Profile("test") // Tem de ser igual ao nome posto no arquivo application.proprieties que o Spring usara essa configuracao apenas no perfil de teste
public class TestConfig implements CommandLineRunner {  // Para executar tudo que estiver dentro deste metodo (Run)
	
	@Autowired  // Com isso o spring vai resolver esta dependencia e associar uma instancia de userRepository aqui dentro
	private UserRepository userRepository;

@Override
public void run(String... args) throws Exception {
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	userRepository.saveAll(Arrays.asList(u1, u2));
} 
}
