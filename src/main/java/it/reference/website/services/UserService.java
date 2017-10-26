package it.reference.website.services;

import it.reference.website.entities.security.User;
import it.reference.website.repositories.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUser(final String username) {
		return userRepository.findById(username).get();
	}

	public List<User> getUsers() {
		return getUsers(Sort.by(Order.asc("username")));
	}

	public List<User> getUsers(final Sort sort) {
		return userRepository.findAll(sort);
	}

	public User saveUser(final User user) {
		return userRepository.save(user);
	}
}
