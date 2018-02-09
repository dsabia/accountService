package com.ing.technicaltest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ing.technicaltest.entity.Account;
import com.ing.technicaltest.entity.User;
import com.ing.technicaltest.exception.UserNotFoundException;
import com.ing.technicaltest.repository.UserRepository;

@RestController
@RequestMapping(path="/{userId}/account")
public class UserAccountService {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, produces={MimeTypeUtils.APPLICATION_JSON_VALUE})
    Collection<Account> getAll(@PathVariable Long userId) {
		User owner = userRepository.findOne(userId);
		if(owner == null) {
			throw new UserNotFoundException("User not found");
		}
    	return owner.getAccounts();
    }
}