package it.reference.website.repositories;

import it.reference.website.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
