package it.reference.website.controllers.admin;

import it.reference.website.models.AreaModel;
import it.reference.website.models.mappers.AreaMapper;
import it.reference.website.services.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
   public String form(final Model model) {
      model.addAttribute("areaModel", new AreaModel());
      return "admin/area";
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
