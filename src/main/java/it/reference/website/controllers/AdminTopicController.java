package it.reference.website.controllers;

import it.reference.website.entities.Topic;
import it.reference.website.models.TopicModel;
import it.reference.website.models.mappers.TopicMapper;
import it.reference.website.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin/topic")
public class AdminTopicController
{
   private final TopicService topicService;
   private final TopicMapper topicMapper;
   
   public AdminTopicController(
            final TopicService topicService,
            final TopicMapper topicMapper) {
      this.topicService = topicService;
      this.topicMapper = topicMapper;
   }
   
   @GetMapping
   public String form(final Model model) {
      model.addAttribute("topicModel", new TopicModel());
      return "admin/topic";
   }
   
   @PostMapping("create")
   public String create(
            final TopicModel topicModel,
            final BindingResult bindingResult,
            final RedirectAttributes redirectAttributes) {
      final Topic topic = topicService.save(topicMapper.topicModelToTopic(topicModel));
      
      if (bindingResult.hasErrors()) {
         return "admin/topic";
      }
      
      redirectAttributes.addAttribute("topicId", topic.getId());
      return "redirect:/topics/{topicId}";
   }
   
   @PostMapping("delete")
   public String delete(@RequestBody final long topicId) {
      topicService.delete(topicId);
      return "redirect:/areas";
   }
}
