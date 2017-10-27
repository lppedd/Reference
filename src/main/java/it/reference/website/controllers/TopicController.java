package it.reference.website.controllers;

import it.reference.website.models.mappers.TopicMapper;
import it.reference.website.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
   public ModelAndView topic(@PathVariable final long topicId) {
      return new ModelAndView("topic").addObject("topic", topicMapper.topicToTopicModel(topicService.get(topicId)));
   }
}
