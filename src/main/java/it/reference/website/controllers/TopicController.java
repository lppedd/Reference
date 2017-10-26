package it.reference.website.controllers;

import it.reference.website.models.TopicModel;
import it.reference.website.models.mappers.TopicMapper;
import it.reference.website.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/topics")
public class TopicController
{
	private final TopicService topicService;
	private final TopicMapper topicMapper;

	public TopicController(
			final TopicService topicService,
			final TopicMapper topicMapper) {
		this.topicService = topicService;
		this.topicMapper = topicMapper;
	}

	@GetMapping("/{topicId}")
	public String topic(@PathVariable final long topicId, final Model model) {
		model.addAttribute("topic", topicService.get(topicId));
		return "topic";
	}

	@PostMapping
	public String add(@Valid final TopicModel topicModel, final Model model, final BindingResult bindingResult) {
		model.addAttribute("topic", topicService.save(topicMapper.topicModelToTopic(topicModel)));
		return bindingResult.hasErrors() ? "topic" : "edit";
	}
}
