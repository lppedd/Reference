package it.reference.website.controllers;

import it.reference.website.models.mappers.AreaMapper;
import it.reference.website.models.mappers.TopicMapper;
import it.reference.website.services.AreaService;
import it.reference.website.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("areas")
public class AreaController
{
   private final AreaService areaService;
   private final TopicService topicService;
   private final AreaMapper areaMapper;
   private final TopicMapper topicMapper;
   
   public AreaController(
            final AreaService areaService,
            final TopicService topicService,
            final AreaMapper areaMapper,
            final TopicMapper topicMapper) {
      this.areaService = areaService;
      this.topicService = topicService;
      this.areaMapper = areaMapper;
      this.topicMapper = topicMapper;
   }
   
   @GetMapping
   public ModelAndView list() {
      return new ModelAndView("areas").addObject("areas", areaMapper.areasToAreaModels(areaService.getAll()));
   }
   
   @GetMapping("{areaId}")
   public ModelAndView topics(@PathVariable final long areaId, final Model model) {
      return new ModelAndView("topics").addObject("topics", topicMapper.topicsToTopicModels(topicService.getByArea(areaId)));
   }
}
