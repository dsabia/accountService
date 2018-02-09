package com.ing.technicaltest.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.technicaltest.entity.User;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void user_is_persisted_correctly() {
		// given
		User user = new User("Test", "User");
		Long initialCount = userRepository.count();
		
		// when
		userRepository.save(user);
		
		// then
		assertThat(userRepository.count(), is(initialCount + 1l));
	}
	
}
