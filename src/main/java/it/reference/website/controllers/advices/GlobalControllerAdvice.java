package it.reference.website.controllers.advices;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalControllerAdvice
{
   private final StringTrimmerEditor stringTrimmerEditor;
   
   public GlobalControllerAdvice() {
      stringTrimmerEditor = new StringTrimmerEditor(true);
   }
   
   @InitBinder
   public void customEditors(final WebDataBinder webDataBinder) {
      webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
   }
}
