package com.ing.technicaltest;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ing.technicaltest.entity.Account;
import com.ing.technicaltest.entity.Currency;
import com.ing.technicaltest.entity.User;
import com.ing.technicaltest.repository.AccountRepository;
import com.ing.technicaltest.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, AccountRepository accountRepository) {

		return (evt) -> {
			User user = userRepository.save(new User("Name", "Surname"));
			
			accountRepository.save(new Account("Main Account", BigDecimal.valueOf(1000d), Currency.EUR, user));
			accountRepository.save(new Account("Credit Card", BigDecimal.valueOf(-200d), Currency.EUR, user));
			accountRepository.save(new Account("US Deposit", BigDecimal.valueOf(50d), Currency.USD, user));
			accountRepository.save(new Account("Swiss Deposit", BigDecimal.valueOf(100000d), Currency.CHF, user));
		};
	}
}
