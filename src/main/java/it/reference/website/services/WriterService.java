package it.reference.website.services;

import it.reference.website.entities.Writer;
import it.reference.website.repositories.WriterRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService
{
   private final WriterRepository writerRepository;
   
   public WriterService(final WriterRepository writerRepository) {
      this.writerRepository = writerRepository;
   }
   
   public Writer getWriter(final String username) {
      return writerRepository.findById(username).get();
   }
   
   public List<Writer> getWriters() {
      return getWriters(Sort.by(Order.asc("username")));
   }
   
   public List<Writer> getWriters(final Sort sort) {
      return writerRepository.findAll(sort);
   }
   
   public Writer saveWriter(final Writer writer) {
      return writerRepository.save(writer);
   }
}
