package it.reference.website.repositories;

import it.reference.website.entities.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, String> { }
