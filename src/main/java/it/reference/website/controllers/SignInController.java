package it.reference.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("signin")
public class SignInController
{
   @GetMapping
   public String form() {
      return "signin";
   }
}
