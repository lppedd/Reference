package it.reference.website.controllers;

import it.reference.website.services.AreaService;
import it.reference.website.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/areas")
public class AreaController
{
	private final AreaService areaService;
	private final TopicService topicService;

	public AreaController(
		  final AreaService areaService,
		  final TopicService topicService) {
		this.areaService = areaService;
		this.topicService = topicService;
	}

	@GetMapping
	public String list(final Model model) {
		model.addAttribute("areas", areaService.getAll());
		return "areas";
	}

	@GetMapping("/{areaId}")
	public String topics(@PathVariable final long areaId, final Model model) {
		model.addAttribute("topics", topicService.getByArea(areaId));
		return "topics";
	}
}
