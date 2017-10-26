package it.reference.website.repositories;

import it.reference.website.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long>
{
   List<Topic> findByAreaId(final long areaId);
}
