package it.reference.website.repositories;

import it.reference.website.entities.Authority;
import it.reference.website.entities.Authority.AuthorityRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityRole> { }
