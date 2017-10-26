package it.reference.website.services;

import it.reference.website.entities.Topic;
import it.reference.website.repositories.TopicRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService
{
	private final TopicRepository topicRepository;
	
	public TopicService(final TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}
	
	public Topic get(final long topicId) {
		return topicRepository.findById(topicId).get();
	}
	
	public List<Topic> getAll() {
		return getAll(Sort.by(Order.asc("name")));
	}
	
	public List<Topic> getAll(final Sort sort) {
		return topicRepository.findAll(sort);
	}
	
	public List<Topic> getByArea(final long areaId) {
		return topicRepository.findByAreaId(areaId);
	}
	
	public Topic save(final Topic topic) {
		return topicRepository.save(topic);
	}
	
	public void delete(final long topicId) {
		topicRepository.deleteById(topicId);
	}
}
