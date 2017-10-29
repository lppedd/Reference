package it.reference.website.controllers;

import it.reference.website.models.WriterModel;
import it.reference.website.models.mappers.WriterMapper;
import it.reference.website.services.WriterService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("signup")
public class SignUpController
{
   private final WriterService writerService;
   private final WriterMapper writerMapper;
   
   public SignUpController(
            final WriterService writerService,
            final WriterMapper writerMapper) {
      this.writerService = writerService;
      this.writerMapper = writerMapper;
   }
   
   @GetMapping
   public ModelAndView form() {
      return new ModelAndView("signup").addObject(new WriterModel());
   }
   
   @PostMapping
   public String signUp(@Valid final WriterModel writerModel, final BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
         return "signup";
      }
      
      writerService.saveWriter(writerMapper.wrtierModelToWriter(writerModel));
      return "redirect:/signin";
   }
}
