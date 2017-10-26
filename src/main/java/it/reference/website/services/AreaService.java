package it.reference.website.services;

import it.reference.website.entities.Area;
import it.reference.website.repositories.AreaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService
{
   private final AreaRepository areaRepository;
   
   public AreaService(final AreaRepository areaRepository) {
      this.areaRepository = areaRepository;
   }
   
   public List<Area> getAll() {
      return getAll(Sort.by(Order.asc("name")));
   }
   
   public List<Area> getAll(final Sort sort) {
      return areaRepository.findAll(sort);
   }
   
   public Area save(final Area area) {
      return areaRepository.save(area);
   }
   
   public void delete(final long areaId) {
      areaRepository.deleteById(areaId);
   }
}
