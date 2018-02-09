package com.ing.technicaltest.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.technicaltest.entity.Account;
import com.ing.technicaltest.entity.Currency;
import com.ing.technicaltest.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void save_with_user() {
		// given
		User user = new User("Test", "User");
		entityManager.persist(user);
		Long initialCount = accountRepository.count();
		
		// when
		Account account = new Account("Test", BigDecimal.ONE, Currency.EUR, user);
		accountRepository.save(account);
		
		// then
		assertThat(accountRepository.count(), is(initialCount + 1l));
	}

	@Test(expected=Throwable.class)
	public void do_not_save_without_user() {
		// given
		User user = null;
		
		// when
		Account account = new Account("Test", BigDecimal.ONE, Currency.EUR, user);
		accountRepository.save(account);
	}
}
