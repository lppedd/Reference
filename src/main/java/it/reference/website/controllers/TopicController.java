package it.reference.website.controllers;

import it.reference.website.models.mappers.TopicMapper;
import it.reference.website.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("topics")
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
   
   @GetMapping("{topicId}")
   public String topic(@PathVariable final long topicId, final Model model) {
      model.addAttribute("topic", topicMapper.topicToTopicModel(topicService.get(topicId)));
      return "topic";
   }
}
