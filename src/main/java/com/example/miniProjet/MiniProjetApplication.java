package com.example.miniProjet;

import com.example.miniProjet.Entity.ClientEntity;
import com.example.miniProjet.classValidation.ValidatePrice;
import com.example.miniProjet.dao.ClientRepository;
import com.example.miniProjet.enums.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com"})
public class MiniProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjetApplication.class, args);
	}

	@Bean
	public ValidatePrice validatePrice(){
		return  new ValidatePrice();
	}

	@Bean
	CommandLineRunner run(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			System.out.print("ok ok ok ");
			ClientEntity client = new ClientEntity();
			client.setPassword(passwordEncoder.encode("password"));
			client.setEmail("user11@111.com");
			client.setUsername("user11@111.com");
			client.setFirstName("slimane1");
			client.setLastName("slimane2");
			client.setAge(19);

			List<RolesEnum> list = new ArrayList<>();
			list.add(RolesEnum.ROLE_CLIENT);

			client.setRolesEntities(list);

			//clientRepository.save(client);
		};
	}


}
