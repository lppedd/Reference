package it.reference.website.controllers;

import it.reference.website.models.AreaModel;
import it.reference.website.models.mappers.AreaMapper;
import it.reference.website.services.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/areas")
public class AdminAreaController
{
   private final AreaService areaService;
   private final AreaMapper areaMapper;
   
   public AdminAreaController(
            final AreaService areaService,
            final AreaMapper areaMapper) {
      this.areaService = areaService;
      this.areaMapper = areaMapper;
   }
   
   @GetMapping
   public ModelAndView form() {
      return new ModelAndView("admin/area").addObject("areaModel", new AreaModel());
   }
   
   @PostMapping("create")
   public String create(@Valid final AreaModel areaModel, final BindingResult bindingResult) {
      areaService.save(areaMapper.areaModelToArea(areaModel));
      return bindingResult.hasErrors() ? "admin/area" : "redirect:/areas";
   }
   
   @PostMapping("delete")
   public String delete(@RequestBody final long areaId) {
      areaService.delete(areaId);
      return "redirect:/admin/areas";
   }
}
