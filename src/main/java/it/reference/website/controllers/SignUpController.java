package it.reference.website.controllers;

import it.reference.website.models.UserModel;
import it.reference.website.models.mappers.UserMapper;
import it.reference.website.services.UserService;
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
   private final UserService userService;
   private final UserMapper userMapper;
   
   public SignUpController(
            final UserService userService,
            final UserMapper userMapper) {
      this.userService = userService;
      this.userMapper = userMapper;
   }
   
   @GetMapping
   public ModelAndView form() {
      return new ModelAndView("signup").addObject("userModel", new UserModel());
   }
   
   @PostMapping
   public String signUp(@Valid final UserModel userModel, final BindingResult bindingResult) {
      userService.saveUser(userMapper.userModelToUser(userModel));
      return bindingResult.hasErrors() ? "signup" : "redirect:/signin";
   }
}
